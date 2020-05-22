public class Car{
    public String color;
    public String model;
    public float value;
    public float tax;

    public Car(String color, String model, float value, float tax) {
        this.color = color;
        this.model = model;
        this.value = value;
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", value=" + value +
                ", tax=" + tax +
                '}';
    }
}

@Test
public void process() {
    List<Consumer<Car>> processors = Arrays.asList(
            c -> c.color = printThread(c.color.toLowerCase()),
            c -> c.model = printThread(c.model.toLowerCase()),
            c -> c.value = printThread(c.value * c.value),
            c -> c.tax = printThread(c.tax / c.tax));

    Arrays.asList(new Car("Red", "AlphaGorilla", 1f, 0.5f), new Car("Blue", "Bloated++", 10f, 0.2f))
            .parallelStream().forEach(c -> {
        System.out.println(c);
        processors.parallelStream().forEach(p -> {
            p.accept(c);
            fakeExpensiveComputation();
        });
        System.out.println(c);
    });
}

private <T> T printThread(T smthg) {
    System.out.println(String.format("Calculated value %s in thread %d", smthg.toString(), Thread.currentThread().getId()));
    return smthg;
}

private void fakeExpensiveComputation() {
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException();
    }
}
public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeNoise() {
        System.out.println(name + "said Meow");
    }
}

public class Dog implements Animal {
    @Override
    public void makeNoise() {
        System.out.println("Woof");
    }
}
public class Car {
    private String type;
    private int model;
    private String color;

    public Car(final String type, final int model, final String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    public String getType() { return this.type; }
    public int getModel() { return this.model; }
    public String getColor() { return this.color; }
}

final Car car = new Car("Fiat", 500, "white");

// To get the color, you must:
car.getColor();
private String manufacturer;
private int power;
private Color color;  // here is the property of enum type

....

public Car(String manufacturer, int power, Color color) {
    this.manufacturer = manufacturer;
    this.power = power;
    this.color = color;
}

Car newCar = new Car("manufacturer", 150, Color.RED);
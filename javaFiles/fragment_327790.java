interface ImmutableCar {
    String getMake();
    String getModel();
}
class Car implements ImmutableCar {
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
    private String make;
    private String model;
    public String getMake() { return make; }
    public void setMake(String m) { make = m; }
    public String getModel() { return model; }
    public void setModel(String m) { model = m; }
}
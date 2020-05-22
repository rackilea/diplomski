Rideable rideable = new Rideable() {
    @Override
    public Car getCar(String name) {
        return new Car(name);
    }
};
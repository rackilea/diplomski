class DumbCar extends Car {
    @Override
    public Hamburger getModel() {
        return new Hamburger();
    }
}
class Car {
    private boolean doorOpened;

    public void openCar() {
        doorOpened = true;
        System.out.println("Car has been opened");
    }

    public void closeCar() {
        doorOpened = false;
        System.out.println("Car has been closed");
    }

    public boolean isTheCarOpen() {
        return doorOpened;
    }
}
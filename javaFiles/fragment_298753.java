class SeaPlane implements Vehicle {
    private Vehicle plane,
                    ship;
    @Override
    public void safetyCheck() {
       plane.safetyCheck();
       ship.safetyCheck()
    }
}
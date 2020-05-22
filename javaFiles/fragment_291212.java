public abstract class Boat extends Vehicle {
    @Override
    public void drive(Surface surface) {
        if (surface.isWater()) {
            doDrive(surface);
        }
    }
    // this is needed to ensure that extending classes really do implement the driving capability!
    public abstract void doDrive(Surface surface);
}
public class DistanceTraveled {

    private double speed;       //speed

    //distanceTravelled constructor
    public DistanceTraveled(double s) {
        speed = s;
    }

    // findDistanceOverTime method
    public double findDistanceOverTime(int hours) {
        return getSpeed() * hours;
    }

    // setSpeed method
    public void setSpeed(double s) {
        s = speed;
    }

    // getSpeed method
    public double getSpeed() {
        return speed;
    }
}
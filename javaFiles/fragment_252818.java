public interface DegreesMeasure {
    double getDegrees();
}

public enum E3 implements DegreesMeasure {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    private final double degrees;

    E3(double degrees) {
        this.degress = degrees;
    }

    @Override
    public double getDegrees() {
        return degrees;
    }
}
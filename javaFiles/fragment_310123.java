abstract class BoatType {
    protected int numSeats;

    public BoatType(int numSeats) {
            this.numSeats = numSeats;
    }
}

final class ScullBoatType extends BoatType {
    public ScullBoatType(int numSeats) {
        super(numSeats);
    }
}

final class SweepBoatType extends BoatType {
    private boolean isPort;
    private boolean isCoxed;

    public SweepBoatType(int numSeats, boolean isPort, boolean isCoxed) {
        super(numSeats);
        this.isPort = isPort;
        this.isCoxed = isCoxed;
    }
}
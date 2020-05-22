public class Island {
    private Point2D center = null;
    private int radius = 0;

    private List<Deposit> deposits = new ArrayList<Deposit>();

    public Island(Point2D center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public void generateDeposits(int numDeposits) {
        for (int i = 0; i < numDeposits; i++) {
            // TODO: I leave it to you to find an x and y inside the island's
            // boundary.
            int x = getIntInsideCircle(center, radius);
            int y = getIntInsideCircle(center, radius);
            if (!depositInLocation(x, y)) {
                deposits.add(new StoneDeposit(x, y));
            } else {
                i--; // TODO: This code could potentially go on forever,
                     // if we keep generating locations that have been used, 
                     // but I'll leave this for you to handle.
            }
        }
    }
}

public abstract class Deposit {
    private Point2D location = null;

    public Deposit(Point2D location) {
        this.location = location;
    }
}

public class StoneDeposit extends Deposit {
    // TODO: You can fill this with StoneDeposit specifics.
}
public class Bird {
    protected boolean flight = true;
    public boolean hasFligth() {
        return flight;
    }
}

public class Penguin extends Bird {
    public Penguin() {
        flight = false;
    }
}
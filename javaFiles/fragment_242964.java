public class Bird {
    public final boolean flight;

    public Bird() {
        this(true);
    }

    protected Bird(boolean flight) {
        this.flight = flight();
    }
}

public class Penguin extends Bird {
    public Penguin() {
        super(false);
    }
}
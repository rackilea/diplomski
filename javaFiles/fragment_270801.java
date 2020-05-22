public class XValues {
    private Double x1;
    private Double x2;
    private Double x3;

    public XValues(Double x1, Double x2, Double x3) {
        setX1(x1);
        setX2(x2);
        setX3(x3);
    }

    public void setX1(Double x1) {
        if (x1 < 0) throw new IllegalArgumentException("x1 can't be negative");
        this.x1 = x1;
    }

    public void setX2(Double x2) {
        if (x2 < 4 || x2 > 8) throw new IllegalArgumentException("x2 must be in range (4, 8)");
        this.x2 = x2;
    }

    public void setX3(Double x3) {
        if (x3 < 0) throw new IllegalArgumentException("x3 can't be negative");
        this.x3 = x3;
    }

    // GETTERS here
}
public static enum pie {
    APPLE_PIE1(1, 250, "apple pie"),
    PUMPKIN_PIE1(2, 300, "pumpkin pie"),
    ...

    private int id;
    private double exp;
    private String label;

    private pie(int id, double exp, String label) {
        this.id = id;
        this.exp = exp;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // optional: I wouldn't do it as it would make debugging harder
    @Override
    public String toString() {
        return label;
    }
}
public final class Roll {
    private static final Random r1 = new Random();
    // We now attribute a value to r uppon construction
    private final int r;
    public Roll() {
        level();
    }

    // Whenever level() is called the value of r is updated
    private static final int level() {
        int s = 1, e = 100;
        int r = r1.nextInt((e - s) + 1) + s;
        this.r = r;
    }

    public int itemType() {
        boolean b = r1.nextBoolean();
        int a = ((b) ? 1 : 2);
        return a;
    }

    public int getR() {
        return r;
    }

}
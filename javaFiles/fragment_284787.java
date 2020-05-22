public static class Move implements Serializable {
    private final int x, y;
    private static final long serialVersionUID = 6696031872468154516L;

    public Move(int a,int b) {
        x = a;
        y = b;
    }
}
public enum Colours {

    RED(R.drawable.redPeg), ... BLUE(R.drawable.bluePeg);

    private final int drawable;

    private Colours(int drawable) {
        this.drawable = drawable;
    }

    public int getDrawable() {
        return this.drawable;
    }
}
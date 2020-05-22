public abstract class AbstractDie implements Die {

    private final int minimum;
    private final int maximum;

    public AbstractDie(int minimum, int maximum) {
        this.minimum= minimum;
        this.maximum = maximum;
    }

    @Override
    public int getMinimum() {
        return minimum;
    }

    @Override
    public int getMaximum() {
        return maximum;
    }

    @Override
    public int roll() {
        return getMinimum() + (int)(Math.random() * getMaximum());
    }

}
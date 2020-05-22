public class BooleanOrInt {

    private boolean isInteger; // Whether value is boolean or int
    private boolean b;
    private int i;

    public BooleanOrInt(boolean b) {
        this.b = b;
        this.isInteger = false;
    }

    public BooleanOrInt(int i) {
        this.i = i;
        this.isInteger = true;
    }

    public boolean isInteger() {
        return this.isInteger;
    }
}
public final class MutableInteger {
{
    private int value;

    public MutableInteger(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

void swap(MutableInteger a, MutableInteger b) {
    int c = a.getValue();
    a.setValue(b.getValue());
    b.setValue(c); 
}
public class OnlyOne {
    static count = 0;
    public static OnlyOne make() {
        if (count > 0) throw ...
        count++;
        return new OnlyOne();
    }
    private OnlyOne() { ...}
}
public class OnlyOne {
    static count = 0;
    public OnlyOne() {
        if (count > 0) throw ...
        count++;
        ...
    }
}
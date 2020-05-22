// note that class name doesn't follow Java conventions here
public class kilobyte {
    private int number;

    public kilobyte(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("argument is null");
        }
        else if (number.intValue() > 1024 || number.intValue() < 0) {
            throw new IllegalArgumentException("argument not within 0 < x < 1024 range");
        }
        else {
            this.number = number.intValue();
        }
    }
    // TODO getter/setter
}
public class Example {
    private static final int[] MAPPING = {0, 100, 200};
    private static final int REGION_LENGTH = 60;

    public static int encode(int value) {
        // TODO apply range check to avoid ArrayIndexOutOfBounds
        return MAPPING[(value / REGION_LENGTH)];
    }

    public static void main(String[] args) {
        System.out.println(encode(160)); // prints 200
    }
}
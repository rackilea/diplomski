public class Test{
    public static void main(String[] args) {
        double before = 100000000000000d;
        double after = before + Double.MIN_VALUE;
        System.out.println(before == after);

        long bits = Double.doubleToLongBits(before);
        bits++;
        double afterBits = Double.longBitsToDouble(bits);
        System.out.println(before == afterBits);
        System.out.println(afterBits - before);
    }
}
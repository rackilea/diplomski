public class Example {
    private static boolean i2b(int i) {
        return i!=0;
    }
    public static boolean isOdd(int i) {
        return i2b(i&1);
    }
    public static void run() {
        for(int i=0; i<10; i++)
            System.out.println(i+": "+(isOdd(i)? "odd": "even"));
    }
}
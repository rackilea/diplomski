public class MyClass {
    public static void main(String args[]) {
        byte h = (byte)0xff;
        byte l = (byte)0xf9;

        int i = (short) ((h << 8) | l);
        System.out.println(i);
    }
}
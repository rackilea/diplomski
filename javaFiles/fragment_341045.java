public class NativeRandom {

    static {
        System.loadLibrary("NativeRandom.so");
    }

    public static native int[] generateRandomIntegers(int size);

    public static void main(String[] args) {
        int[] randomNumbers = generateRandomIntegers(10);
        System.out.println(randomNumbers);
    }
};
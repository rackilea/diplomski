public class ArrayTesting {
    private static long totalTotal = 0L;
    private static int[] ints = new int[10];
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            runTest();
        }
        System.out.println("Final Length of Array: " + ints.length);
        System.out.println("Total Time was: " + totalTotal);
    }
    private static void runTest() {
        long startTime = System.nanoTime();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i * 2;
        }
        ints = doubleArray(ints);
        for (int i = 9; i < ints.length; i++) {
            ints[i] = i * 2;
        }
        long testTime = System.nanoTime() - startTime;
        totalTotal = totalTotal + testTime;
    }

    private static int[] doubleArray(int[] old) {
        int[] doubled = new int[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            doubled[i] = old[i];
        }
        return doubled;
     }
}
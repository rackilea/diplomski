import java.util.ArrayList;
class ArrayListTester {
    public static ArrayList<Integer> arl = new ArrayList<Integer>();
    public static long totalTotal = 0L;
    public static void main(String[] args) {
        //Set initial size for ArrayList to 10
        while(arl.size() < 10) arl.add(0);
        //Setting the size was not timed.
        for (int i = 0; i < 5; i++) {
            runTest();
        }
        System.out.println("Total ArrayList size: " + arl.size());
        System.out.println("Total Time: " + totalTotal);
    }
    public static void runTest() {
        long startTime1 = System.nanoTime();
        int initialSize = arl.size();
        for (int i = 0; i < initialSize * 2; i++) {
            if (i < initialSize)
                arl.set(i, ((Integer) i * 2));
            else
                arl.add((Integer) i * 2);
        }
        long totalForRun = System.nanoTime() - startTime1;
        totalTotal = totalTotal + totalForRun;
    }
}
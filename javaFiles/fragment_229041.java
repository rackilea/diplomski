public class Test {
    public static void main(String[] args) {
        Object[] array = new Object[10_000_000];
        Runtime rt = Runtime.getRuntime();
        long usedBefore = rt.totalMemory() - rt.freeMemory();
        for (int i = 0; i < array.length; i++ ) {
            array[i] = new Object();
        }
        long usedAfter = rt.totalMemory() - rt.freeMemory();
        System.out.println(usedBefore);
        System.out.println(usedAfter);
        System.out.println((double)(usedAfter - usedBefore) / array.length);
    }
}
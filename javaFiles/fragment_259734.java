public class Searcher implements Runnable {
    private int intToFind;
    private int startIndex;
    private int endIndex;
    private int[] arrayToSearchIn;

    public Searcher(int x, int s, int e, int[] a) {
        intToFind = x;
        startIndex = s;
        endIndex = e;
        arrayToSearchIn = a;
    }

    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (arrayToSearchIn[i] == intToFind) System.out.println("Found x at index: " + i);
        }
    }
}

public class Starter {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int numberOfThreads = 5;
        int x = 20;
        findElement(numberOfThreads, x, a);
    }

    private static void findElement(int numberOfThreads, int x, int[] a) {
        int sizeOfa = a.length;
        int range = sizeOfa/numberOfThreads;
        for (int i = 0; i <= numberOfThreads-1; i++) {
            Thread searcher;
            if (i == numberOfThreads-1) {
                searcher = new Thread(new Searcher(x, i*range, sizeOfa-1, a));
            } else {
                searcher = new Thread(new Searcher(x, i*range, i*range+range-1, a));
            }
            searcher.start();
        }
    }
}
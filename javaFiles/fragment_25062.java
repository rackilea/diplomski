public class QuickSort extends Thread {
    final int[] entries;

    public QuickSort(int[] list) {
        entries = list;
    }

    public void run() {
        // do your quick sort.
        // the final int[] entries just keeps the list from being
        // replaced at run time, the entries themselves are not frozen.
    }
}
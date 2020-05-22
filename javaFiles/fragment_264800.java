public class BubbleSortNumeric {
    public static void main (String [] args) {
        Integer [] unsortedData1 = getDataInput();
        Integer [] unsortedData2 = new Integer[unsortedData1.length];
        System.arraycopy(unsortedData1, 0, unsortedData2, 0, unsortedData1.length);
        Integer [] sortedDataAscending;
        Integer [] sortedDataDescending;
        long start = System.nanoTime();
        sortedDataAscending = bubbleSortAscending(unsortedData1);
        sortedDataDescending = bubbleSortDescending(unsortedData2);
        // ...
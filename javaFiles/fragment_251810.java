public class MyArray {

    private int[] array;

    // Constructor to instantiate a new array
    public MyArray(int length) {
        array = new int[length];
    }

    public int length() {
        return array.length;
    }

    // getter for integers
    public int getInts(int counter) {
        return array[counter];
    }

    // setter for integers
    public void setInts(int counter, int input) {
        array[counter] = input;
    }

    // getter for entire array
    public int[] getArray() {
        return array;
    }

    // setter for entire array
    public void setArray(int[] newArray) {
        this.array = newArray;
    }

    public int intAt(int index) {
        return array[index];
    }

    // Method to print Arrays
    public void printArray() {
        System.out.println("\nThe length of the array is " + array.length);

        for (int i = 0; i < array.length; i++)
            System.out.println("array[" + i + "] = " + array[i]);
    }

    // Method to check if array is sorted
    public boolean isSortedArray() {
        boolean isSorted = true;
        for (int i = 1; i < array.length; i++)
            if (array[i] > array[i-1]) {
                isSorted = false;
                break;
            } 
        System.out.println("The array is " + (isSorted ? "sorted" : "not sorted"));
        return isSorted;
    }

    // method to calc sum
    public long sum() {
        long sum = 0L;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        return sum;
    }

    // method to calc Average
    public double average() {
        return (double) sum() / array.length;
    }

    // method to calc sqSum
    public long sqSum() {
        long sqSum = 0L;
        for (int i = 0; i < array.length; i++)
            sqSum += array[i] * array[i];
        return sqSum;
    }

    // method to calculate variance
    public double variance() {
        return (double) sqSum() / array.length;
    }
}
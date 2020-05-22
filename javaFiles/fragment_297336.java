public class QuicksortApp {
private static int[] a = { 10, 12, 9, 23, 45, 31, 67, 44, 32, 77 };

public static void main(String[] args) {

    int left = 0;
    // you do not need to pass the length -1 because the for loop takse care
    // of it.
    int right = a.length;

    // prints the given array
    printArray();

    quickSort(left, right);

    System.out.println("");

    // prints the sorted array
    printArray();

}

private static void quickSort(int left, int right) {

    if (left >= right)
        return;
    //no need to pass the pivot since the pivot will always be the left most element in the array
    int partition = partition(left, right);

    quickSort(0, partition - 1);
    quickSort(partition + 1, right);
}

private static int partition(int left, int right) {

    int pivot = a[left];

    int splitter = left;
    /*
     * This is cleanest approach to the algorithm. I am not going to mention
     * the pseudo code of the alog but since you were trying to modify the
     * array in place,you need to decide what will be your separation
     * point,In my case this is called "splitter". The splitter takes care
     * of creating a boundary between the elements greater than and lesser
     * than the pivot
     */
    for (int i = left; i < right; i++) {
        // Check if the element currently being scanned is less than the
        // pivot
        if (pivot > a[i]) {
            // If it is lesser,then left most element which is greater than
            // the pivot with this element and increase your boundary
            // pointer(splitter) by one
            swap(++splitter, i);
        }
        // Do not do anything if the element is lesser than the pivot.

    }
    // swap the pivot and element at the splitter position
    // Please note that the splitter position contains the right most
    // element with a value lesser than the pivot
    swap(left, splitter);
    // return the splitter,which indicates the position of your pivot and
    // provides you information regarding how you should split and partition
    // to implement the Divide and Conquer Paradigm
    return splitter;
}

public static void swap(int left, int right) {
    int temp = a[left];
    a[left] = a[right];
    a[right] = temp;
}

public static void printArray() {
    for (int i : a) {
        System.out.print(i + " ");
    }
}
}
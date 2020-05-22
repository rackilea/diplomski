public class PrintSubarrayMain {

    public static void main(String args[]) {
        PrintSubarrayMain psm = new PrintSubarrayMain();
        int arr[] = { 1, 2, 3, 4 };
        int range = 3;
        psm.printSubArray(arr, range);
    }

    void printSubArray(int arr[], int range) {
        if (range <= arr.length)
            for (int i = 0; i < arr.length - range + 1; i++) {
                for (int j = i; j < i + range; j++)
                    System.out.print(arr[j] + " ");
                System.out.println();
            }
        else
            System.out.println("Range is greater than the size of the array");
    }
}
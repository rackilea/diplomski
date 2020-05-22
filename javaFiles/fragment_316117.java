public class PrintSubarrayMain {

    public static void main(String args[]) {
        PrintSubarrayMain psm = new PrintSubarrayMain();
        int arr[] = { 1, 2, 3, 4 };
        psm.printSubArray(arr);
    }

    void printSubArray(int arr[]) {     
        for (int i = 0; i <arr.length-1; i++) {
            for(int j=i;j<i+2;j++)
                System.out.print(arr[j]+" ");
            System.out.println();
        }       
    }
}
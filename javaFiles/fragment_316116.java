public class PrintSubarrayMain {

    public static void main(String args[]) {
        PrintSubarrayMain psm = new PrintSubarrayMain();
        int arr[] = { 1, 2, 3, 4 };
        psm.printSubArray(arr);
    }

    void printSubArray(int arr[]) {     
        for (int i = 0; i <arr.length-1; i++) {
            int [] subArr=new int[2];
            System.arraycopy(arr,i, subArr, 0, 2);
            for (int j=0;j<2;j++)
                System.out.print(subArr[j]+ " ");
            System.out.println();
        }       
    }
}
public class InsertionSort {
    static void insertionSort1(int n, int[] arr) {

        int copy = arr[n - 1];

        int i = n - 1;
        while (i > 0 && copy < arr[i - 1]) {

            arr[i] = arr[i - 1];

            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
            i--;
        }
        arr[i] = copy;
        System.out.println("#### RESULT ####");
        for (int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println("\n#### END ####\n");
    }

    public static void main(String[] args)
    {
        //10
        //2 3 4 5 6 7 8 9 10 1
        int[] arr ={2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
        int n = arr.length;
        insertionSort1(n, arr);


        //5
        //2 4 6 8 3
        arr= new int[5];
        n = arr.length;

        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 6;
        arr[3] = 8;
        arr[4] = 3;

        insertionSort1(n, arr);
    }
}
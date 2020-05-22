import static java.lang.System.out;

class Main {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }

            print(arr, i);
        }
    }

    public static void print(int[] arr, int p) {
        int i = 0;
        out.print(
            "after " + (p + 1) + (p + 1 == 1 ? 
            " pass:   " : " passes: ") + "[ "
        );

        while (i < arr.length - 1 - p) {
            out.print(arr[i++] + ", ");
        }

        out.print("(");

        while (i < arr.length - 1) {
            out.print(arr[i++] + ", ");
        }

        out.println(arr[i] + ") ]");
    }

    public static void main(String[] args) {
        int[] arr = {9,5,7,1,4,7,2};
        bubbleSort(arr);
    }
}
public class QSort {
    private static int numOps = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {
        File file = new File("Qtest.txt");
        PrintWriter output = new PrintWriter(file);
        int n, i;
        System.out.println("warming up...");
        Qsort(randomInts(1000000), 0, 100000-1);
        System.out.println("Enter the times of iteration");
        n = sc.nextInt();
        for (int j = 1000; j <= n * 1000; j = j + 1000) {
            int[] array = randomInts(j);
            long startTime = System.nanoTime();
            numOps = 0;
            Qsort(array, 0, j - 1);
            long endTime = System.nanoTime();
            output.println(j + " " + (endTime - startTime) + " " + numOps);
            System.out.println("After sorting the time elapsed is " + (endTime - startTime) + " numOps: " + numOps);
        }
        output.close();
    }

    private static int[] randomInts(int j) {
        int i;Random r = new Random();
        int array[];
        array = new int[j];
        for (i = 0; i < j; i++) {
            array[i] = r.nextInt(2000);
        }
        return array;
    }

    public static void Qsort(int A[], int start, int end) {
        if (start >= end) return;
        int p = partition(A, start, end);
        Qsort(A, start, p - 1);
        Qsort(A, p + 1, end);
    }

    public static int partition(int A[], int start, int end) {
        int pivot = A[end];
        int p = start;
        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) {
                int temp = A[i];
                A[i] = A[p];
                A[p] = temp;
                p++;
                numOps++;
            }
        }
        int temp = A[p];
        A[p] = A[end];
        A[end] = temp;
        return p;
    }
}
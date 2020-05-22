public class Test {
    public static void main(String[] args) {
        int[] A = {1, 1};
        Partition(A, 0, 1);
    }

    private static int Partition(int[] A, int left, int right){
        int pivot = A[right];
        int i = left;
        int j = right;

        while (true) {
            while ( (A[j] > pivot)) {
                j--;
            }
            while ((A[i] < pivot)) {
                i++;
            }
            if (i < j){
                int swap = A[j];
                A[j] = A[i];
                A[i] = swap;
            }else{
                return i;
            }
        }
    }
}
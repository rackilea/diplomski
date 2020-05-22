import java.util.Arrays;
public class CountingSort {
    public static void main(String[] args) {
        int[] array_A = {6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
        int[] array_B = new int[array_A.length];
        int k = 6;
        countingSort(array_A,array_B,k);
        System.out.println(Arrays.toString(array_B));
    }
    public static void countingSort(int[] A, int[] B, int k){
        int[] C = new int[k+1];
        for(int i = 0; i<=k; i++){
            C[i] = 0;
        }
        for(int j = 0; j<A.length; j++){
            C[A[j]] ++;
        }
        for(int i = 1; i<=k; i++){
            C[i] += C[i-1];
        }
        for(int j = A.length-1; j>=0; j--){
            B[--C[A[j]]] = A[j];
        }
    }
}
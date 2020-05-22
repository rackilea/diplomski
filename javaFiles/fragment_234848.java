import java.util.*;
import java.lang.*;
import java.io.*;

class standardDev
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        double sum = 0.0;
        double mean = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            mean += arr[i];
        }
        mean /= n;
        for(int i = 0; i < n; i++) {
            sum += Math.pow(arr[i] - mean,2);
        }
        System.out.printf("%.1f", Math.sqrt(sum/n));
   }
}
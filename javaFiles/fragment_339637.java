import java.util.*;

public class Lab5b {
    public static void main(String args[]) {
        double[] a = { 1, 0, 0 };
        double[] b = { 0, 1, 1 };
        double[] c = { 1, 1, 1 };
        double[] d = { 0, 0, 1 };

        // Call the method
        System.out.println("ab=" + distance(a, b) + ",  ac=" + distance(a, c) + ",  ad=" + distance(a, d));
    }

    // Define method
    public static double distance(double[] a, double[] b) {
        double dist = 0;
        dist = Math.sqrt (
                (a[0]-b[0])*(a[0]-b[0]) +
                (a[1]-b[1])*(a[1]-b[1]) +
                (a[2]-b[2])*(a[2]-b[2]) );

        return dist;
    }
}
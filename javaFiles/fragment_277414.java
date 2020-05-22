import java.util.*;

public class Flatten {
    static float[] flatten(float[]... arrs) {
        int L = 0;
        for (float[] arr : arrs) {
            L += arr.length;
        }
        float[] ret = new float[L];
        int start = 0;
        for (float[] arr : arrs) {
            System.arraycopy(arr, 0, ret, start, arr.length);
            start += arr.length;
        }
        return ret;
    }
    public static void main(String[] args) {
        Vector<float[]> v = new Vector<float[]>();
        v.add(new float[] { 1,2,3, });
        v.add(new float[] { 4, });
        v.add(new float[] {  });
        v.add(new float[] { 5,6, });

        float[] flattened = flatten(v.toArray(new float[0][]));
        System.out.println(Arrays.toString(flattened));
        // prints "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]"
    }
}
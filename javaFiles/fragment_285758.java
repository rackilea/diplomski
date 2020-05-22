public class RayGetFirst {
    //method go will return an array
    //containing all values > the first value in the array
    //from the array parameter ray
    public static int[] go(int[] ray) {
        int first = ray[0];
        int k = 0;                           // set an index
        int[] result = new int[ray.length];  // allocate storage for values.
        for( int i = 1; i<ray.length; i++) {
           if(first < ray[i]) {
              result[k++] = ray[i];     // copy values
           }
        }

    // now establish a new array of length k
        int [] ret = new int[k];
    // and copy the first `k` values in `result` to that array.
    // Then return that array.
        for (int i = 0; i < k; i++) {
            ret[i] = result[i];
        }

        return ret;
    }
}
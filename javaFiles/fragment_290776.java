import java.util.Arrays;

public class LBS {

public static int binarySearchBetween(int[] arr, int end, int val) {
    int low = 0, high = end;
    if (val < arr[0]) {
        return 0;
    }
    if (val > arr[end]) {
        return end + 1;
    }
    while (low <= high) {
        int mid = (low + high) / 2;
        if (low == high) {
            return low;
        } else {
            if (arr[mid] == val) {
                return mid;
            }
            if (val < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
    }
    return -1;
}

/**
 * Returns an array of LIS results such that arr[i] holds the result of the 
 * LIS calculation up to that index included.
 * @param arr The target array.
 * @return An array of LIS results.
 */
public static int[] lisArray(int[] arr) { // O(n*logn) 
    /* Regular LIS */
    int size = arr.length;
    int[] t = new int[size]; 
    t[0]=arr[0];
    int end = 0;

    /* LIS ARRAY */
    int[] lis = new int[size]; // array for LIS answers.
     // Start at 1 (longest sub array of a single element is 1)
    lis[0]=1; 

    for (int i=1; i<size; i++) { // O(n) * O(logn) 
        int index = binarySearchBetween(t, end, arr[i]);
        t[index] = arr[i];
        if (index > end) {
            end++;
        }
        lis[i]=end+1; // saves the current calculation in the relevant index
    }
    return lis;
}

/*
* Input:  {1, 11, 2, 10, 4, 5, 2, 1}
* Output: {1,  2, 2,  3, 3, 4, 4, 4}
* Each index in output contains the LIS calculation UP TO and INCLUDING that 
* index in the original array.
*/

public static int[] ldsArray(int[] arr) { // O(n*logn)
    int size = arr.length;
    int t[] = new int[size];
    for (int i = 0; i < size; i++) {
        t[i] = -arr[i];
    }
    int ans[] = lisArray(t);
    return ans;
}

public static int lbs(int[] arr) { // O(n*logn)
    int size = arr.length;
    int[] lis = lisArray(arr); // O(n*logn)
    int[] lds = ldsArray(arr); // O(n*logn)
    int max = lis[0]+lds[size-1]-1;
    for (int i=1; i<size; i++) { // O(n)
        max = Math.max(lis[i]+lds[size-i]-1, max);
    }
    return max;
}

public static void main (String[] args)
{
        int arr[] = {1,11,2,10,4,5,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(lbs(arr));
}
}
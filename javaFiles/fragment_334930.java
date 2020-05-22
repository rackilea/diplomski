public class solver {


    //brute force algorithm with complexity O(n^2)
    long bruteforce(long array[], int n){

        long max = Long.MIN_VALUE;
        //We go throght all the elements of the list and we try all the
        //posible combinations with all the other elements
        for (int i = 0; i < n; i++){
            long sum = 0;
            for (int j = i; j < n ; j++){
                //we add the an element in the sum
                sum += array[j];
                //we check if the sum with the new element is greater that the value we had before
                if(sum > max){
                    //if it's greater, it becomes the new value
                    max = sum;
                }
            }
        }
        //we return the maximum value we have found
        return max;
    }

    //to implement the divide and conquer algorithm we have to take into account the
// maximum subarray can have elements in the right subarray and in the left subarray
    long maxCrossingSum(long array[], long l, long m, long h){
        long sum = 0;
        long left_sum = Integer.MIN_VALUE;
        //Has the elements on the left part of the arrray
        for ( int i = (int)m; i >= l; i--){
            sum = sum + array[i];
            if( sum > left_sum ){
                left_sum = sum;
            }
        }

        sum = 0;
        long right_sum = 0;
        //Has the elements in the right part of the array
        for ( int j = (int)m+1; j <= h; j++){
            sum = sum + array [j];
            if (sum > right_sum){
                right_sum = sum;
            }
        }
        //returns the sun of the elements on the left and the right of the array
        return left_sum + right_sum;
    }

    //returns the sum of the maximum subarray
    long maxSubarraySum(long array[], long l, long h){

        if(l == h)
            return array[1];

        long m = (l + h)/2;
        //checks which is the maximum between left and right
        long maxBetweenLeftRight = max(maxSubarraySum(array, l, m), maxSubarraySum(array, m+1,h));
        long crossing = maxCrossingSum(array, l, m,h-1);
        //retrns the maximum between one of the sides and the crossing sum
        return max(maxBetweenLeftRight, crossing);

    }
    //divide and conquere algorithm with complexity O(nlogn)
    //only made to make it more understandable from the main
//can call maxSubarraySum and it would be the same
    long divideconquer (long array[], int l, int h){

        return maxSubarraySum(array, l, h);
    }

    //dynamic programming algorithm with complexity O(n)
    long dynprog(long array[], int n){
        long a = array[0];
        long b = array[0];
        //for all the elements checks if the sum was better until the
        //step before or adding the element
        for (int i = 1 ; i < n; i++){
            a= max (a+ array[i], array[i]);
            b= max(b, a);
        }
        return b;
    }

    private long max(long a, long b) {
        if (a > b ) return a;
        else return b;
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MyClass {
     public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int[] reversed = reverseArray(arr);
        System.out.println(Arrays.toString(reversed));
    }

    public static int[] reverseArray(int[] arr)
    {
        if (arr.length == 0)
            return arr;

        // remove first element   
        int first = arr[0];
        int[] list = Arrays.copyOfRange(arr, 1, arr.length);

        //Calling Function Recursively get reversed array
        int[] returnArr = reverseArray(list);

        //Add original first to the last of the arrayToReturn
        returnArr = Arrays.copyOf(returnArr, returnArr.length + 1);
        returnArr[returnArr.length - 1] = first;

        return  returnArr;
    }
}
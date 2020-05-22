import java.util.*;

public class PermutationTest{

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void permutations(char[] arr, int loc, int len, ArrayList<String> result) {
        if (loc == len) {
            result.add(new String(arr));
            return;
        }

        // Pick the element to put at arr[loc]
        permutations(arr, loc + 1, len, result);
        for (int i = loc + 1; i < len; i++) {
            // Swap the current arr[loc] to position i
            swap(arr, loc, i);
            permutations(arr, loc + 1, len, result);
            // Restore the status of arr to perform the next pick
            swap(arr, loc, i);
        }
    }

    public static ArrayList<String> permutations(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str.length() == 0) { return result; }
        permutations(str.toCharArray(), 0, str.length(), result);
        return result;
    }

    public static void main(String []args){
        ArrayList<String> result = permutations("123");
        for (String str : result) {
            System.out.println(str);   
        }
    }
}
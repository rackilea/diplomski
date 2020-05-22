public class Problem2_ProductsOfAllIntsExceptAtIndex {

    public static int[] myFunction(int[] arg) {
        // making all variables global (=> static) doesn't make sense in this case
        int input = 1;    
        int[] temp_arr;
        int[] arr ;

        arr = new int[arg.length];
        for (int i = 0; i < arg.length; i++) {
            temp_arr = Arrays.copyOf(arg, arg.length);  // clone the original array; otherwise you overwrite the original one
            temp_arr[i] = 1; // or should put it null
            for (int j = 0; j < temp_arr.length; j++) {
                input *= temp_arr[j];
            }
            arr[i] = input;
            input = 1; // reset
        }
        return arr;

    }

    public static void main(String[] args) {
        int [] arr = myFunction(new int[] { 0, 1, 2, 3 });
        System.out.println(Arrays.toString(arr));
    }

}
public static int EvenNum(int[] arr, int index)
{
    if (index == arr.length) return 0;  // Stop recursion
    //return (arr[index] % 2 == 0 ? 1 : 0) + EvenNum(arr, index + 1);
    // or....
    int result;
    if ((arr[index] % 2) == 0) {    // Is even
        result = 1;
    }
    else {                          // Is odd
        result = 0;
    }
    return result + EvenNum(arr, index + 1);
}

public static void main(final String... args)
{
    // Start with index = 0
    System.out.println(EvenNum(new int[]{1,2,3,4,5}, 0));
}
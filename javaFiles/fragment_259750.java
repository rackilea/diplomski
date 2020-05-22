public class App 
{
    public static void main( String[] args )
    {
        int arr[] = {3, 5, 7, 1};
        System.out.println( go(arr) );
    }

    static int go(int[] array) {
        int oddPos = -1;
        for (int i = 0; i < array.length; i++) {
            //check if already din't find an odd number and if current number is odd
            if (oddPos == -1 && array[i] % 2 == 1) {
                oddPos = i;
            }
            // check if already found an odd number and current number is even
            if (oddPos != -1 && array[i] % 2 == 0) {
                return i - oddPos;
            }
        }
        return -1;
    }
}
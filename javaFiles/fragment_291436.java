public class TEST {
public static void main(String[] args) {
    int[] a =  {1,2,3,5,7,8,9};
    System.out.println(LastInAnArray(a));
}
public static int LastInAnArray(int[] array) {

    final int MIN_VALUE = 0;

    int lastNum = array[array.length - 1];

    if (array == null) {
        return MIN_VALUE;
    }
    else {
        return lastNum;
    }
}
/**
 *
 * @param a an array of of numbers
 * @return the number of numbers that can divided by 2
 */
public static int what (int []a){
    return countingPairNumberes (a, 0, a.length - 1);
}

/**
 *
 * @param a an array of of numbers
 * @param lo the begining of the array
 * @param hi the end of the array
 * @return the number of numbers that can divided by 2
 */
private static int countingPairNumberes (int [] a, int lo, int hi)
{
    if (lo <= hi) {
        int counter = countingPairNumberes (a, lo+1, hi);
        if(a[lo] % 2 == 0)
            counter++;
        return counter;

    } else {
        return 0;
    }

}
private int lowerSum(int[] ar, int index)
{
    if(index == 0) {
        lowerSum = 0;
    } else {
        lowerSum += ar[--index];
    }
    return lowerSum;
}
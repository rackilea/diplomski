private int[] calculateSum(int[] array, int index) 
{
    if (index == 0) {
        return Arrays.copyOf (array, array.length);
    } else {
        int[] result = calculateSum(array, index-1);
        result[index] += result[index-1];
        return result;
    }
}
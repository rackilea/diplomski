public static int[] doubleSize(int[] j) 
{
    int[] newArray = new int[j.length * 2]
    for (int i = 0; i < j.length; i++) {
        newArray[i] = j[i];
    }
    return newArray;
}
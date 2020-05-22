String[][] deepCopy(String [][] arr)
{
    String[][] temp = new String[arr.length][];
    for (int i=0; i<arr.length; i++)
    {
         temp[i] = new String[arr[i].length];
         for (int j=0; j<arr[i].length; j++)
             temp[i][j] = arr[i][j];
    }
    return temp;
}
public static int[] toEOBArray(double[] in) 
{
    int[][] arrays = new int[10][];
    int len = 0;
    for (int i = 0; i < 10; i++)
    {
        arrays[i] = fixArray(tempVal[i]);
        len += arrays[i].length;
    }
    int[] out = new int[len];
    int offset = 0;
    for (int i = 0; i < 10; i++)
    {
        System.arraycopy(arrays[i],0,out,offset,arrays[i].length);
        offset += arrays[i].length;
    }
    return out;
}
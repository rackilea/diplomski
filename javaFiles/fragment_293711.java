public static int kSmallest(int[] a, int[] b, int aStart, int aEnd,
          int bStart, int bEnd, int k)
{
    int[] aa = new int[aEnd-aStart];
    java.lang.System.arraycopy(a, aStart, aa, 0, aa.length);

    int[] bb = new int[bEnd-bStart];
    java.lang.System.arraycopy(b, bStart, bb, 0, bb.length);

    if(k>aa.length || k>bb.length)
    {
        throw new ArrayIndexOutOfBoundsException();
    }

    return aa[k]<bb[k] ? aa[k] : bb[k];
}
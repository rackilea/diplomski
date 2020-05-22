public static int maxConsecutiveEvenSumLength (int []a)
{
    int oddCount = 0;
    int firstOddIndex = -1;
    int lastOddIndex = a.length;
    for (int i=0; i<a.length; i++)
    {
        if (a[i] % 2 == 1) {
          oddCount++;
          if (firstOddIndex < 0)
              firstOddIndex = i;
          lastOddIndex = i;
        }
    }
    if (oddCount % 2 == 0) {
        return a.length;
    } else {
        return Math.max(a.length - firstOddIndex - 1,lastOddIndex);
    }
}
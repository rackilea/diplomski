public static int maxEvenSumLength (int []a)
{
    int oddCount = 0;
    for (int i=0; i<a.length; i++)
    {
        if (a[i] % 2 == 1) {
          oddCount++;
        }
    }
    return (oddCount % 2 == 0) ? a.length : (a.length - 1);
}
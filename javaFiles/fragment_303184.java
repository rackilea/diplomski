public static int[] createCountersArray(int[] A)
{
    int maxValue = max(A) + 1;

    int[] Result = new int[A.length];
    int[] Count = new int[maxValue];

    for (int i = 0; i < A.length; i++) {
        int x = Count[A[i]];
        x++;
        Count[A[i]] = x;
    }

    for (int i = 1; i < Count.length; i++) {
        Count[i] = Count[i] + Count[i - 1];
    }

    for (int i = A.length -1; i >= 0; i--) {
        int x = Count[A[i]];
        x--;
        Result[x] = A[i];
        Count[A[i]] = x;
    }
    return Result;
}
public static int[] baseChanger(int[] f, int A, int B, int P)
{
    if(A < 2) return null;
    if(B < 2) return null;
    return toRadix(toDecimal(f, A), B, P);
}
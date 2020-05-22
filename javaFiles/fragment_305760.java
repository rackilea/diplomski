private static int counter = 0;
// your code here, following is a part of your perms method
if (n == 1)
{
    for (int i = 0; i < A.length; i++)
    {
        B[counter][i] = A[i];
    }
    counter++;
}
//and my code corrected too:
public static int[][] perms(int[] a){
    int[][] perms = new int[factorial(a.length)][a.length]; //+1 is not necessary
    counter=0; //necessary to call it again
    perms(a,perms,a.length);
    return perms;
}
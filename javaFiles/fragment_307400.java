static int MAX = 100;
static long[] A;
public static void buildArray()
{
  A = new long[MAX+1];
  F(MAX);
}

public static long F(int N)
{
  long val;
  if (N < 2)
    val = N;
  else if (A[N] != 0) // HEY! It's already calculated! Awesome! Just return it.
    return A[N];
  else
    val = F(N-1) + F(N-2);
  A[N] = val;
  return val;
}
public static void main(String[] args)
{
  buildArray();
  for (int N = 0; N <= MAX; N++)
    System.out.println(N + " " + A[N]);
}
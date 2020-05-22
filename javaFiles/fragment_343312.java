public static int findMin(int a, int b, int c)
{
    int minimum = Math.min(a, b);
    int minimum2 = Math.min(minimum, c);
    System.out.println("The minimum of " + a + ", " + b + " and " + c + " is " + minimum2);
    return minimum2;
}
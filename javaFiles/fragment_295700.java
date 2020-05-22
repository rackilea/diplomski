main()
{
    specialSum(50, 7);
}

 public static int specialSum(int a, int toDivide)
 {
    return (a == 0) ? 0 : (a >= 1 && a%2 == 0 && a%7 != 0) ? a + specialSum(a - 1, toDivide) : specialSum(a - 1, toDivide);
 }
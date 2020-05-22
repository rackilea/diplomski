public static void main (String [] args)
{
    int a = 5, b = 23;
    System.out.println (transform (a, b) + " = " + b);
}

public static String transform (int a, int b)
{
    if (a == b) return "" + a;
    if (b % 2 == 0 && 2 * a <= b)
    {
        b = b / 2;
        return transform (a, b) + " * 2";
    }
    else
    {
        b = b - 1;
        return "(" + transform (a, b) + " + 1)";
    }
}
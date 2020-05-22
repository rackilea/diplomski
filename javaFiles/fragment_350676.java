public static int abs(int num, int n)
{
    int shifter = -1 << (n - 1);
    if ((num & shifter) == 0) 
        return num;
    shifter = shifter << 1;
    return (~num + 1) & ~shifter;
}
class Example
{
    public static void main (String[] args) throws java.lang.Exception
    {
        long x = 0x1000000020000000l;
        long result = ((x & 0xFFFFFFFF00000000l) >> 32) | ((x & 0x00000000FFFFFFFFl) << 32);
        System.out.printf("0x%016X\n", x);
        System.out.printf("0x%016X\n", result);
    }
}
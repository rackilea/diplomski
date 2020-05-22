interface IntToByteWithInt
{
    int VER_EQUAL = 1;
    int VER_GREATER = 2;
    int VER_GREATER_EQUAL = 3;
}

interface IntToByteWithByte
{
    byte VER_EQUAL = 1;
    byte VER_GREATER = 2;
    byte VER_GREATER_EQUAL = 3;
}

public class IntToByte
{
    public static void main(String[] args)
    {
        Integer a = IntToByteWithInt.VER_EQUAL;

        // Type mismatch: cannot convert from byte to Integer  
        Integer b = IntToByteWithByte.VER_EQUAL;
    }
}
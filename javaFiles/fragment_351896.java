static byte[] trim(byte[] bytes)
{
    int i = bytes.length - 1;
    while (i >= 0 && bytes[i] == 0)
    {
        --i;
    }

    return Arrays.copyOf(bytes, i + 1);
}

public static void main(String[] args)
{
    byte[] bytes = { 0, 1, 2, 0, 3, 4, 5, 0, 6, 0, 0, 7, 8, 9, 10, 0, 0, 0, 0 };

    byte[] trimmed = trim(bytes);

    return;
}
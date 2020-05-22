private static String shiftMessage(String input, int n) {
    String str = "";

    for (int i = 0; i < input.length(); i++)
    {
        char ch = input.charAt(i);
        if (ch >= 'A' && ch <= 'Z')
        {
            ch = (char) (ch + n);
            if (ch > 'Z')
            {
                ch = (char)(ch - 26);
            }
        }
        else if (ch >= 'a' && ch <= 'z')
        {
            ch = (char)(ch + n);
            if (ch > 'z')
            {
                ch = (char)(ch - 26);
            }
        }
        str = str + ch;
    }
    return str;
}
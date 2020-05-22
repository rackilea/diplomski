public final boolean ParantezKontrol(String input)
{
    return ParantezKontrol(input, 0);
}

//Java does not support optional parameters. So you can overload this method
//ORIGINAL public bool ParantezKontrol(string input, int numOpen = 0)
public final boolean ParantezKontrol(String input, int numOpen)
{
        if (numOpen < 0)
        {
            return false;
        }
        if (isNullOrEmpty(input))
        {
            return numOpen == 0;
        }

        char c = input.charAt(0);
        String rest = input.substring(1);
        if (c == '(')
        {
            return ParantezKontrol(rest, numOpen + 1);
        }
        else if (c == ')')
        {
            return ParantezKontrol(rest, numOpen - 1);
        }
        else
        {
            return ParantezKontrol(rest, numOpen);
        }
}
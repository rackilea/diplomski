import java.util.ArrayList;
import java.util.List;


public class Main
{
    public static void main(final String[] argv)
    {
        final int startValue;
        final int iterations;
        final List<String> list;

        startValue = Integer.parseInt(argv[0]);
        iterations = Integer.parseInt(argv[1]);
        list = encodeAll(startValue, iterations);
        System.out.println(list);
    }

    private static List<String> encodeAll(final int startValue, final int iterations)
    {
        final List<String> allEncodings;

        allEncodings = new ArrayList<String>();

        for(int i = 0; i < iterations; i++)
        {
            try
            {
                final int    value;
                final String str;
                final String encoding;

                value = i + startValue;
                str = String.format("%06d", value);
                encoding = encoding(str);
                allEncodings.add(encoding);
            }
            catch(final BadNumberException ex)
            {
                // do nothing
            }
        }

        return allEncodings;
    }

    public static String encoding(String str)
        throws BadNumberException
    {
        final int[]         digit;
        final StringBuilder s;

        digit = new int[10];

        for(int i = 0; i < 6; i++)
        {
            digit[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        digit[6] = ((4*digit[0])+(10*digit[1])+(9*digit[2])+(2*digit[3])+(digit[4])+(7*digit[5])) % 11;
        digit[7] = ((7*digit[0])+(8*digit[1])+(7*digit[2])+(digit[3])+(9*digit[4])+(6*digit[5])) % 11;
        digit[8] = ((9*digit[0])+(digit[1])+(7*digit[2])+(8*digit[3])+(7*digit[4])+(7*digit[5])) % 11;
        digit[9] = ((digit[0])+(2*digit[1])+(9*digit[2])+(10*digit[3])+(4*digit[4])+(digit[5])) % 11;

        // Insert Parity Checking method (Vandermonde Matrix)
        s = new StringBuilder();

        for(int i = 0; i < 9; i++)
        {
            s.append(Integer.toString(digit[i]));
        }

        if(digit[6] == 10 || digit[7] == 10 || digit[8] == 10 || digit[9] == 10)
        {
            throw new BadNumberException(str);
        }

        return (s.toString());
    }
}

class BadNumberException
    extends Exception
{
    public BadNumberException(final String str)
    {
        super(str + " cannot be encoded");
    }
}
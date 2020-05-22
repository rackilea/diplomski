public class Main
{
    private static final long RADIX = -2L * (long)Integer.MIN_VALUE;

    public static void main(final String... args)
    {
        System.out.println(stringify(new int[]{0})); // 0
        System.out.println(stringify(new int[]{1})); // 1
        System.out.println(stringify(new int[]{Integer.MAX_VALUE})); // 2^31-1
        System.out.println(stringify(new int[]{Integer.MIN_VALUE})); // 2^31
        System.out.println(stringify(new int[]{-1})); // 2^32-1
        System.out.println(stringify(new int[]{1, 0})); // 2^32
        System.out.println(stringify(new int[]{1, -1})); // 2^33-1
        System.out.println(stringify(new int[]{-1, -1})); // 2^64-1
        System.out.println(stringify(new int[]{1, 0, 0})); // 2^64
    }

    private static String stringify(final int[] _iArr)
    {
        final int[] iArr = new int[_iArr.length];
        System.arraycopy(_iArr, 0, iArr, 0, _iArr.length);
        final char[] ret = new char[10 * iArr.length];
        int retIndex = ret.length;
        while(true)
        {
            boolean isZero = true;
            int carry = 0;
            for(int i = 0; i < iArr.length; ++i)
            {
                long val = unsignedInt2Long(iArr[i]);
                if(val != 0L)
                    isZero = false;
                val += carry * RADIX;
                carry = (int) (val % 10L);
                val /= 10L;
                iArr[i] = long2UnsignedInt(val);
            }
            if(isZero)
            {
                if(retIndex == ret.length)
                    return "0";
                else
                    return new String(ret, retIndex, ret.length - retIndex);
            }
            assert(retIndex > 0);
            ret[--retIndex] = (char) (carry + (int)'0');
        }
    }

    private static long unsignedInt2Long(final int unsignedInt)
    {
        if(unsignedInt >= 0)
            return unsignedInt;
        else
            return unsignedInt + RADIX;
    }

    private static int long2UnsignedInt(final long _long)
    {
        assert(_long >= 0L);
        assert(_long < RADIX);
        if(_long <= (long) Integer.MAX_VALUE)
            return (int) _long;
        else
            return (int) (_long - RADIX);
    }
}
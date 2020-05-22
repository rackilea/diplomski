public static boolean recurse(boolean[] ary)
{
    if (ary.length == 1) {
        return ary[0];
    }

    return ary[0] && recurse(Arrays.copyOfRange(ary, 1, ary.length));
}
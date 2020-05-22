public static Gender getByInt(final int i)
{
    for (final Gender g: values())
        if (g.gender == i)
            return g;
    return null; // not found
}
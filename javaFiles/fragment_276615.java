// Turn all 'F's into 'f's
private int bigFToSmallF(final int inputChar)
{
    return 'F' == inputChar ? 'f' : inputChar;
}

// Turn all 'f's into '0's
private int smallFToZero(final int inputChar)
{
    return 'f' == inputChar ? '0' : inputChar;
}

private String anyFToZeroes(final String input)
{
    final StringBuilder sb = new StringBuilder(input.length());

    input.chars().map(this::bigFToSmallF).map(this::smallFToZero)
        .forEach(sb::appendCodePoint);

    return sb.toString();
}
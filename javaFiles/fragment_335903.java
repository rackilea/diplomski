public String removeRepetitions(final String input)
{
    if (input.isEmpty())
        return input;

    final int len = input.length();
    final StringBuilder sb = new StringBuilder(length);

    char current = input.charAt(0);
    char c;
    sb.append(current);

    for (int i = 1; i < len; i++) {
        c = input.charAt(i);
        if (c != current) {
            sb.append(c);
            current = c;
        }
    }

    return sb.toString();
}
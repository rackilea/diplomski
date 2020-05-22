private static final Pattern NUMPATTERN = Pattern.compile("\\d+([.,])\\d+");

// ...

// Supposes a custom MyException class
public double doParseDouble(final String input)
    throws MyException
{
    final Matcher m = NUMPATTERN.matcher(input);
    if (!m.matches())
        throw new MyException("Non number characters in input");

    final String separator = m.group(1);
    final Locale locale = ".".equals(separator)
        ? Locale.US : Locale.FRENCH;

    final NumberFormat fmt = NumberFormat.getInstance(locale);

    try {
        return fmt.parse(input).doubleValue();
    } catch (NumberFormatException e) {
        throw new MyException(e);
    }
}
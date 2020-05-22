public static void main(final String[] args)
{
    final InputStream is = System.in;
    final StringBuilder sb = new StringBuilder(1024);
    try
    {
        int i;
        while ((i = is.read()) >= 0)
        {
            sb.append((char)i);
            if (sb.substring(sb.length()-2).equals("\r\n"))
            {
                break;
            }
        }
    }
    catch (final IOException e)
    {
        throw new RuntimeException(e);
    }
    System.out.print(sb.toString());
}
private String jsonToString(final HttpServletRequest httpServletRequest) throws IOException
{
    final StringBuilder buffer = new StringBuilder();
    final BufferedReader reader = httpServletRequest.getReader();
    String line;
    while ((line = reader.readLine()) != null)
    {
        buffer.append(line);
    }
    final String data = buffer.toString();
    return data;
}
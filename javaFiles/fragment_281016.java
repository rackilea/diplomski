byte[] rawBytes = /* whatevs */

try
{
    String decoded = new String(rawBytes, Charset.forName("UTF-8"));
    // or
    String decoded = new String(rawBytes, "UTF-8");
    // best, if you're using Java 7 (thanks to @ColinD):
    String decoded = new String(rawBytes, StandardCharsets.UTF_8);
}
catch (UnsupportedEncodingException e)
{
    // see http://stackoverflow.com/a/6030187/139010
    throw new AssertionError("UTF-8 not supported");
}
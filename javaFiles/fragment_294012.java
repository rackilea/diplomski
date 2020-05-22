protected String invoke(String path, InputStream data) throws TomcatManagerException,
    IOException
{
    ...

    if (this.username != null)
    {
        String authorization = toAuthorization(this.username, this.password);
        connection.setRequestProperty("Authorization", authorization);
    }
    ...
/**
 * Gets the HTTP Basic Authorization header value for the supplied username and password.
 * 
 * @param username the username to use for authentication
 * @param password the password to use for authentication
 * @return the HTTP Basic Authorization header value
 */
private static String toAuthorization(String username, String password)
{
    StringBuilder buffer = new StringBuilder();
    buffer.append(username).append(':');
    if (password != null)
    {
        buffer.append(password);
    }
    return "Basic " + new String(Base64.encodeBase64(buffer.toString().getBytes()));
}
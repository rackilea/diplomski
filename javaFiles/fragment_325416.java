private static InputStream doRequest(final String url, final String requestMethod, final Map<String, String> map) 
{
    try 
    {
        final HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
        conn.setDoOutput(requestMethod.equals(METHOD_POST) || requestMethod.equals(METHOD_PUT));
        conn.setRequestMethod(requestMethod);
        // following line was missing and caused PUT not to work.
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String arguments = "";
        if (map != null && !map.isEmpty()) 
        {
            final StringBuilder sb = new StringBuilder();
            for (String key : map.keySet()) 
            {
                sb.append(sb.length() > 0 ? "&" : "");
                sb.append(URLEncoder.encode(key, HTTP_CHARACTER_ENCODING));
                sb.append("=");
                sb.append(URLEncoder.encode(map.get(key), HTTP_CHARACTER_ENCODING));
            }
            conn.getOutputStream().write(sb.toString().getBytes());
            conn.getOutputStream().close();
            arguments = sb.toString();
        }
        conn.connect();

        final int rc = conn.getResponseCode();
        final String responseMessage = conn.getResponseMessage();
        if (rc != 200)
            logger.info("response " + rc + " (" + responseMessage + ") from " + requestMethod + " " + url + " args:" + arguments);
        if (rc > 399) 
        {
            final String str = stream2String(conn.getErrorStream());
            logger.info("error response:" + str);
            return null;
        } 
        else 
        {
            return getWrappedInputStream(
                conn.getInputStream(), GZIP_ENCODING.equalsIgnoreCase(conn.getContentEncoding())
            );
        }
    } 
    catch (IOException e) 
    {
        throw new TrelloException(e.getMessage());
    }
}
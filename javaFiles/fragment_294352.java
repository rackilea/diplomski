@RequestMapping(value = "/v2/convertToJson", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
public String getRssFeedAsJson() throws IOException, IllegalArgumentException {
    String xmlString = readUrlToString("http://www.sample.com/feed");
    JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
    byte[] ptext = xmlJSONObj.toString().getBytes(ISO_8859_1); 
    String jsonResponse = new String(ptext, UTF_8); 
    return jsonResponse;
}

public static String readUrlToString(String url) {
    BufferedReader reader = null;
    String result = null;
    String retValue = null;
    try {
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setReadTimeout(2 * 1000);
        conn.connect();
        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        result = builder.toString();
        retValue = result.replaceAll("[^\\x00-\\x7F]", "");
    } 
    catch (IOException e) {
        e.printStackTrace();
    } 
    finally {
        if (reader != null) {
            try {
                reader.close();
            } 
            catch (IOException ignoreOnClose) {
            }
        }
    }
    return retValue;
}
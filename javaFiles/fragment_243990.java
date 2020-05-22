private static HttpClient httpClient = new DefaultHttpClient();
private static HttpPost httpPost = new HttpPost(RRD_URL);

    public static String sendData(List<NameValuePair> data) {
    StringBuffer buffer = new StringBuffer();
    BufferedReader rd = null;
    try {
        httpPost.setEntity(new UrlEncodedFormEntity(data));
        HttpResponse httpResponse = httpClient.execute(httpPost);

        rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String line;
        while ((line = rd.readLine()) != null) {
            buffer.append(line);
        }
    } catch (IOException e) {
        e.printStackTrace(System.out);
    } finally {
        try {
            if (rd != null) {
                rd.close();
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    return buffer.toString();
}
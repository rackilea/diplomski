public String makePOSTRequestNew(String urlString,
        List<NameValuePair> nameValuePairs) {
    URL url;
    String response = "";
    try {
        url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                os, "UTF-8"));
        writer.write(getQuery(nameValuePairs));
        writer.flush();
        writer.close();
        os.close();

        InputStream responseStream = new BufferedInputStream(
                conn.getInputStream());
        BufferedReader responseStreamReader = new BufferedReader(
                new InputStreamReader(responseStream));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = responseStreamReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        responseStreamReader.close();
        response = stringBuilder.toString();
        conn.connect();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return response;
}
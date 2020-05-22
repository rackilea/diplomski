public HttpResponse getResponse(String url) throws IOException {
    httpClient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
    return httpClient.execute(new HttpGet(url));
}


public String getSource(String url) throws IOException {
            StringBuilder sb = new StringBuilder();
            HttpResponse response = getResponse(url);
            if (response.getEntity() == null) {
                throw new IOException("Response entity not set");
            }
            BufferedReader contentReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = contentReader.readLine();

            while ( line != null ){
                sb.append(line)
                  .append(NEW_LINE);
                line = contentReader.readLine();
            }
            return sb.toString();
    }
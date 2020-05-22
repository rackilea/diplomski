private String prettyJsonResponse(HttpResponse response) throws IOException{
    StringBuffer result = new StringBuffer();
    String line = "";
    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }   
    return result.toString();
}
private final String USER_AGENT = "Mozilla/5.0";

// HTTP POST request
private void sendPost() throws Exception {
try  {
    String url = "http://myurl";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("Accept-Language", "UTF-8");
    con.setRequestProperty("content-type", "application/xml");

    String urlParameters = "<myXML></myXML>";

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();
catch (Exception e) {
    e.printStackTrace();
}
}
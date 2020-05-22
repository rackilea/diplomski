public void test() throws Exception {
    String ELEVATION_API_URL =  "https://maps.googleapis.com/maps/api/elevation/json";

    String USER_AGENT = "Mozilla/5.0";

    String urlParameters = "locations=6.9366681,79.9393521&sensor=true";


    URL obj = new URL(ELEVATION_API_URL + "?" + urlParameters);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    con.setRequestProperty("Content-Language", "en-US");

    //String urlParameters = request;

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(urlParameters);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
}
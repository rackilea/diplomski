private void sendGet() throws Exception {

    String url = "http://dota2.gamepedia.com/Dota_2_Wiki";

    URL obj = new URL(url);
    CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'GET' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();

    System.out.println(response.toString());

}
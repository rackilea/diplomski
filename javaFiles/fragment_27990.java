public String getUserOrders(String pair,String limit,String offset,String status,String side) throws IOException, BadResponseException
{
    String req="limit="+limit+"&offset="+offset+"&pair="+pair+"&side="+side+"&status="+status;
    String operation="orders/user?"+req;
    String signature=getSignature("");
    URL url = new URL(baseUrl+operation);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setDoOutput( true );
    con.setInstanceFollowRedirects( false );

    con.setRequestProperty("Authorization", "TDAX-API "+this.key);
    con.setRequestProperty("Signature",signature);
    con.setRequestProperty("Content-Type", "application/json"); 
    con.setRequestProperty("charset", "utf-8");
    con.setRequestProperty("User-Agent", "java client");
    con.setUseCaches( false );

    int responseCode=con.getResponseCode();

    if(responseCode!=HttpURLConnection.HTTP_OK){
        throw new BadResponseException(responseCode);
    }
    BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));

    StringBuilder result = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
        result.append(line);
    }
    rd.close();
    return result.toString();
}
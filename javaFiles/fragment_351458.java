public String requestScan(int scan_Id, String token, String ID) throws MalformedInputException, ProtocolException, IOException {

    try {
        String endpoint = "https://host:port/scans/" + scan_Id + "/export?history_id=" ID;
        URL url = new URL(endpoint);

        String payload= "{\"format\" : \"csv\"}";

        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("X-Cookie", "token=" + token);
        con.setRequestProperty("X-ApiKeys", "accessKey="+"324324;" + 
                "secretKey="+"43242;");

        //WRITING THE PAYLOAD to the http call
        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
        writer.write(payload);
        writer.close();

        //READING RESPONSE
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer jsonString = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            jsonString.append(line);
        }
        br.close();
        con.disconnect();

        return jsonString.toString();
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
}
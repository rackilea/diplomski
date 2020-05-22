URL url = new URL("http://api.fliptop.com/s2/v1/find_contact?api_key=xxxxxxxxxxxxxxxxxxxxxx");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestMethod("POST");
    connection.setDoOutput(true);
    connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
    writer.write(data);  // data = "json={\"contact\": { \"email\": \"robbie@fliptop.com\"}}"
    writer.close();

    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {        
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(connection.getInputStream(), UTF_8));

        String line;
        while ((line = reader.readLine()) != null) {
            result += line;
        }       
    }
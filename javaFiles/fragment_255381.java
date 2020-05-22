String uri = "http://poweranalyzer-skyglover.rhcloud.com/blackouts/";
    URL url = new URL(uri);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json");

    String input = "{\"blackoutDate\":\"2016/05/03\", \"blackoutTime\":\"18:45:36\"}";

    OutputStream os = conn.getOutputStream();
    os.write(input.getBytes());
    os.flush();

    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
        throw new RuntimeException("Failed : HTTP error code : "
                + conn.getResponseCode());
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));

    String output;
    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
        System.out.println(output);
    }

    conn.disconnect();
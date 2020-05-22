HttpURLConnection conn = null;
   try {

    URL url = new URL("http://site/MyRestURL");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Accept", ""); // add your content mime type

    if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                + conn.getResponseCode());
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(
        (conn.getInputStream())));

    String output;
    while ((output = br.readLine()) != null) {
        System.out.println(output);
    }

    conn.disconnect();

  } catch (Exception e) {

    e.printStackTrace();

  }
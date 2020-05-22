URL url;

    try {
        url = new URL("http://127.0.0.1:8080/test/huge");
    } catch (Exception et) {
        System.out.println("Videos URL is broken");
        Assert.fail(et.getMessage());
        return;
    }

    HttpURLConnection hc = null;

    try {
        hc = (HttpURLConnection) url.openConnection();

        String login = "admin:admin";
        final byte[] authBytes = login.getBytes(StandardCharsets.UTF_8);

        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        hc.addRequestProperty("Authorization", "Basic " + encoded);

        System.out.println("Authorization: " + hc.getRequestProperty("Authorization"));

        hc.setDoInput(true);
        //hc.setDoOutput(true); <== removed, otherwise 415 unsupported media type
        hc.setUseCaches(false);

        hc.setRequestMethod("GET");
        hc.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
        hc.setRequestProperty("Accept", "application/json,text/html,application/hal+json,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*");
    } catch (Exception et) {
        System.out.println("Can't prepare http URL con");
    }

    System.out.println(hc.toString());

    BufferedReader br = null;

    try {
        InputStreamReader reader = new InputStreamReader(hc.getInputStream()); // <== the request is a GET, data is in input
    } catch (Exception et) {
        System.out.println("Can't get reader to videos stream");
    }

    int rc = hc.getResponseCode();

    System.out.println("response code: " + rc);
    System.out.println("response message: " + hc.getResponseMessage());

    Assert.assertEquals(200, rc);
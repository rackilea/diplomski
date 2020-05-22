public String sendData() throws IOException {
    // curl_init and url
    URL url = new URL("http://some.host.com/somewhere/to/");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    //  CURLOPT_POST
    con.setRequestMethod("POST");

    // CURLOPT_FOLLOWLOCATION
    con.setInstanceFollowRedirects(true);

    String postData = "my_data_for_posting";
    con.setRequestProperty("Content-length", String.valueOf(postData.length()));

    con.setDoOutput(true);
    con.setDoInput(true);

    DataOutputStream output = new DataOutputStream(con.getOutputStream());
    output.writeBytes(postData);
    output.close();

    // "Post data send ... waiting for reply");
    int code = con.getResponseCode(); // 200 = HTTP_OK
    System.out.println("Response    (Code):" + code);
    System.out.println("Response (Message):" + con.getResponseMessage());

    // read the response
    DataInputStream input = new DataInputStream(con.getInputStream());
    int c;
    StringBuilder resultBuf = new StringBuilder();
    while ( (c = input.read()) != -1) {
        resultBuf.append((char) c);
    }
    input.close();

    return resultBuf.toString();
}
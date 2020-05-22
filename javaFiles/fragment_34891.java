// HTTP POST request, sends data in filename to the hostUrl
 private void sendPost(String hostUrl, String filename) throws Exception {

    URL url = new URL(hostUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    //add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", "testUA");
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

    // Send post request
    con.setDoOutput(true);
    DataOutputStream remoteStream = new DataOutputStream(con.getOutputStream());

    byte[] fileBuffer = new byte[1024];
    FileInputStream partFile = new FileInputStream(filename);
    BufferedInputStream bufferedStream = new BufferedInputStream(partFile);

    //read from local filePart file and write to remote server
    int bytesRead = -1;
    while((bytesRead = bufferedStream.read(fileBuffer)) != -1)
    {
       remoteStream.write(fileBuffer, 0, bytesRead);
    }

    bufferedStream.close();

    remoteStream.flush();
    remoteStream.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + hostUrl);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    //read server repsonse
    while ((inputLine = in.readLine()) != null) {
       response.append(inputLine);
    }
    in.close();

    //print result
    System.out.println("Host responded: ");
    System.out.println(response.toString());

 }
URL url = new URL("YOUR_URL");

    HttpURLConnection myURLConnection = (HttpURLConnection)url.openConnection();
    String userCredentials = "username:password";
    String basicAuth = "Basic " + java.util.Base64.getEncoder().encodeToString(userCredentials.getBytes());
    myURLConnection.setRequestProperty ("Authorization", basicAuth);
    myURLConnection.setRequestMethod("GET");

    BufferedInputStream file = new BufferedInputStream(myURLConnection.getInputStream());
    PDFParser parser = new PDFParser(file);
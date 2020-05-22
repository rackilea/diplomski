try {
    URL url = new URL("https://www.sandbox.freelancer.com");
    HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
    BufferedReader br = 
         new BufferedReader(new InputStreamReader(conn.getInputStream()));

} catch (MalformedURLException e) {
}
public static void main(String[] args) throws Exception {

    URL url = new URL("http://www.google.com");

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setConnectTimeout(5000);    // 5 seconds
    conn.setRequestMethod("GET");       
    conn.connect();
    BufferedReader rd  = new BufferedReader(new InputStreamReader(conn.getInputStream()));

    String line;
    while ((line = rd.readLine()) != null) {
        System.out.println(line);
    }
    conn.disconnect(); 
}
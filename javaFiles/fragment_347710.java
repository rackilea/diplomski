protected String doInBackground(String... arg0) {

    try {
        URL url = new URL("http://www.google.com/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            conn.setDoInput(true);
            conn.setDoOutput(true);
            input = new InputStreamReader(conn.getInputStream());
            in =new BufferedReader(input);
            System.out.println("HELLO");
        }
        finally {
            conn.disconnect();
        }
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}
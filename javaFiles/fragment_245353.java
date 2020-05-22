public static void main(String[] args) throws IOException {
    URL url = new URL(pushURL);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/restService");
    conn.setConnectTimeout(30000);
    conn.setReadTimeout(30000);
    String input = writer.getBuffer().toString();
    OutputStream os = conn.getOutputStream();
    for (char c : input.toCharArray()) {
        os.write(c);
    }
    os.close();

    if(conn.getResponseCode() == 200){
        System.out.println("Success");
    } else {                 
        System.out.println("Time out set for 30 seconds");
    } 
}
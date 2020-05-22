private static final int CONNECTION_TIMEOUT = (int) TimeUnit.SECONDS.toMillis(15);
private static final int READ_TIMEOUT = (int) TimeUnit.SECONDS.toMillis(15);

public static void main(String[] args) {
    String address = "https://twitter.com/aaroadwatch";
    System.out.println(get(address));
}

public static String get(String address) {
    String result = null;
    HttpURLConnection conn = null;
    InputStream in = null;
    try {
        // building api url
        URL url = new URL(address);
        System.out.println("GET URL " + url.toString());
        // establishing connection with server
        conn = (HttpURLConnection) url.openConnection();
        // building headers
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setConnectTimeout(CONNECTION_TIMEOUT);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            in = new BufferedInputStream(conn.getInputStream());
            // building output string from stream
            StringBuilder sb = new StringBuilder();
            int b;
            while ((b = in.read()) != -1) {
                sb.append((char) b);
            }
            String output = sb.toString().replace("\n", "");
            System.out.println("GET RES " + output);
            result = output;
        }
    } catch (MalformedURLException ex) {
        System.err.println("malformed url");
        ex.printStackTrace();
    } catch (IOException ex) {
        System.err.println("I/O exception");
        ex.printStackTrace();
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ex) {
            }
        }
        if (conn != null) {
            conn.disconnect();
        }
    }
    return result;
}
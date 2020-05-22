StringBuffer text = new StringBuffer();
        HttpURLConnection conn = null;
        InputStreamReader in = null;
        BufferedReader buff = null;
        try {
            URL page = new URL(
                    "http://example.com/");
// URLEncoder.encode(someparameter); use when passing params that may contain symbols or spaces use URLEncoder to encode it and conver space to %20...etc other wise you will get a 404
            conn = (HttpURLConnection) page.openConnection();
            conn.connect();
            /* use this if you need to
            int responseCode = conn.getResponseCode();

            if (responseCode == 401 || responseCode == 403) {
                // Authorization Error
                Log.e(tag, "Authorization Error");
                throw new Exception("Authorization Error");
            }

            if (responseCode >= 500 && responseCode <= 504) {
                // Server Error
                Log.e(tag, "Internal Server Error");
                throw new Exception("Internal Server Error");
            }*/
            in = new InputStreamReader((InputStream) conn.getContent());
            buff = new BufferedReader(in);
            String line = "anything";
            while (line != null) {
                line = buff.readLine();
            String found = interpretHtml(line);
            if(null != found)
                return found; // comment the previous 2 lines and this one if u need to load the whole html document.
                text.append(line + "\n");
            }
        } catch (Exception e) {
            Log.e(Standards.tag,
                    "Exception while getting html from website, exception: "
                            + e.toString() + ", cause: " + e.getCause()
                            + ", message: " + e.getMessage());
        } finally {
            if (null != buff) {
                try {
                    buff.close();
                } catch (IOException e1) {
                }
                buff = null;
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
                in = null;
            }
            if (null != conn) {
                conn.disconnect();
                conn = null;
            }
        }
        if (text.toString().length() > 0) {
            return interpretHtml(text.toString()); // use this if you don't need to load the whole page.
        } else return null;
    }

private String interpretHtml(String s){
    if(s.startsWidth("<textTag class=\"text\"")){
    return s.substring(22, s.length() - 10);
    }
    return null;
}
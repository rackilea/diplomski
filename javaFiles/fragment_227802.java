public class URLReader {

    public static byte[] read(String from, String to, String string) {
        try {
            String text = "http://translate.google.com/translate_a/t?"
                    + "client=o&text=" + URLEncoder.encode(string, "UTF-8")
                    + "&hl=en&sl=" + from + "&tl=" + to + "";
            URL url = new URL(text);
            URLConnection conn = url.openConnection();
            // Look like faking the request coming from Web browser solve 403 error
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String json = in.readLine();
            byte[] bytes = json.getBytes("UTF-8");
            in.close();
            return bytes;
            //return text.getBytes();
        } catch (Exception e) {
            System.out.println(e);
            // becarful with returning null. subsequence call will return NullPointException.
            return null;
        }
    }
}
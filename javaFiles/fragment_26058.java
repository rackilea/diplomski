public class Rate_fetch {
    String total = "";
    boolean b = true;

    public String rate(String dt) {
        StringBuilder sb = new StringBuilder();
        new Thread(new Runnable() {

            public void run() {

                try {

                    URL url = new URL(tally_ipaddr + "/prorate.jsp?plist="
                            + sss.toString().trim());

                    HttpURLConnection urlConnection = (HttpURLConnection) url
                            .openConnection();
                    InputStream in = new BufferedInputStream(urlConnection
                            .getInputStream());
                    BufferedReader r = new BufferedReader(
                            new InputStreamReader(in));
                    StringBuilder sb = new StringBuilder();
                    String s;
                    while (true) {
                        s = r.readLine();
                        if (s == null || s.length() == 0)
                            break;
                        sb.append(s);
                    }
                    b = true;
                } catch (Exception e) {
                    b = true;
                }
            }

        }).start();
        while (b) {

        }
        total = sb.toString();
        return sb.toString();

    }
}
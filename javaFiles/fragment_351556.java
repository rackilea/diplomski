public static void main(String[] args) {

    String inputLine;

    try {
        URL url = new URL("http://www.twitter.com");

        URLConnection conn =  url.openConnection();
        conn.setRequestProperty(
            "User-Agent",
            "Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(conn.getInputStream(),"utf-8"));                        

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);

            // Fail if any line contains more than one sequential question mark
            assert !inputLine.contains("??");
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }

}
public String myMethos(){

        String urlString="http://example.com/WS/StaticExample.php?method=sayHello&name=World";
        URL url=new URL(urlString);
        URLConnection connection=url.openConnection();
        connection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.close();
        JSONObject jsonobj = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String decodedString="",URLstrJson="";

        while ((decodedString = in.readLine()) != null) {
          URLstrJson+=decodedString;
        }
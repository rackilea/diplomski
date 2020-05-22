public String connect() {

    try {
    /*URL url = new URL("phpfilelocation.php");*/
        String data = URLEncoder.encode("un", "UTF-8") + "=" + URLEncoder.encode(un, "UTF-8");
        data += "&" + URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8");
        data += "&" + URLEncoder.encode("uid", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(uid), "UTF-8");

        String urlString = "phpfilelocation.php" + "?" + data;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(false);
        conn.setRequestMethod("GET");
        conn.connect();

        //remove:
        //OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        //wr.write(data);
        //wr.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line = null;

        // Read Server Response
        while((line = reader.readLine()) != null)
        {
            sb.append(line);
            break;
        }
        return sb.toString();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "fail";
}
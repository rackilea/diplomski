@Override
protected Void doInBackground(String... urls) {
    CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
    String data="";
    try {
        URL url = new URL(urls[0]);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        InputStream in = new BufferedInputStream(conn.getInputStream());
        String html = readStream(in);

        Pattern pattern = Pattern.compile("\\t+(\\d+) ([+-]) (\\d+) = <input name=\"answer\"");
        Matcher matcher = pattern.matcher(html);

        Integer res = null;
        if (matcher.find()) {
            if (matcher.group(2).equals("-"))
                res = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(3));
            else if (matcher.group(2).equals("+"))
                res = Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3));
        }

        if (res != null) {
            data += URLEncoder.encode("field1", "UTF-8")
                    + "=" + URLEncoder.encode(field1, "UTF-8");
            data += "&" + URLEncoder.encode("field2", "UTF-8") + "="
                    + URLEncoder.encode(field2, "UTF-8");
            data += "&" + URLEncoder.encode("answer", "UTF-8") + "="
                    + URLEncoder.encode(Integer.toString(res), "UTF-8");
        }
        conn.disconnect();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        URL url = new URL(urls[0]);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setDoOutput(true); //ENABLE POST REQUEST
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(data);
        wr.flush(); wr.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        data = readStream(in);
        conn.disconnect();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    // Now data==final html respond
    Document doc = Jsoup.parse(data);
    Elements allAnchorTags = doc.select("tr");
    return null;
}
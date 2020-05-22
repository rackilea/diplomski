public void search(String q, int o) {
    final String query = q;
    final int offset = o;
    Thread searchThread = new Thread() {
        public void run() {
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://192.168.1.43/test/test.php");
                //HttpPost httpPost = new HttpPost("http://vkontakte.ru/gsearch.php?section=audio&q=" + URLEncoder.encode(query, HTTP.UTF_8) + "&offset=" + offset);
                httpPost.setHeader("Cookie", "remixsid=" + guid);
                HttpResponse response = httpClient.execute(httpPost);
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println(responseBody);
            } catch(Exception e) {
                System.out.println(e.toString());
            }
        }
    };
    searchThread.start();
}
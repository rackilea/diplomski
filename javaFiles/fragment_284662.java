private static Document sendRequest(String url) {
        Document doc = null;
        try {
            Connection connect = Jsoup.connect(url);
            connect.request().followRedirects(false);
            URI u = new URI(url);
            doc = connect.url(new URI(u.getScheme(), u.getUserInfo(), u.getHost(), u.getPort(), URLDecoder.decode(u.getPath(), "UTF-8"), u.getQuery(), u.getFragment()).toURL()).get();
            if (connect.response().statusCode() == 301 && connect.response().header("Location") != null) {
                return sendRequest(connect.response().header("Location"));
            }
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void main(String[] args) {

        String url = null;
        url = "https://www.fifaindex.com/de/team/110395/Lanús";
//        url = "https://www.fifaindex.com/de/team/1877/BocaJuniors";
        Document doc = sendRequest(url);
        Elements strength = doc.getElementsByClass("badge r3");
        System.out.println(Integer.parseInt(strength.get(0).text()));
        System.out.println(Integer.parseInt(strength.get(1).text()));
        System.out.println(Integer.parseInt(strength.get(2).text()));
}
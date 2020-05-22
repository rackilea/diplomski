public class Main { 

    public static void main(String[] args) throws IOException {


        final String HOSTS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
            "<supported-filehosts>"+
            "<host url=\"info.net\"/>"+
            "<host url=\"test.com\"/>"+
            "<host url=\"app.to\"/>"+
            "</supported-filehosts>";
        List<String> hostUrls = new ArrayList<String>();

        Document doc = Jsoup.parse(HOSTS);
        Elements links = doc.select("host[url]");
        for (Element link : links) {
            hostUrls.add(link.attr("url"));
        }
        System.out.println(hostUrls.toString());
    }   
}
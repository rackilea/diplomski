public class RSSFeedManager{

News[] articles;

public News[] getFeed(String html) {
    try {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(html.getBytes()));

        NodeList items = doc.getElementsByTagName("item");
        articles = new News[items.getLength()];

        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            News news = new News(getValue(item, "title"),getValue(item, "description").substring(0,100),"");
            articles[i] = news;
        }
    } catch (Exception e) {
        //e.printStackTrace();
        Log.d("EXCEPTION PARSING",e.toString());
    }
    return articles;
}

public String getValue(Element parent, String nodeName) {
    return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
}
}
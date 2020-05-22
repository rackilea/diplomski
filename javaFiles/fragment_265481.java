public class Test {

    public static void main(String[] args) {
        String xml = 
                "<item>\r\n" + 
                "   <title> this is title 1 </title>\r\n" + 
                "   <description> description 1 </description>\r\n" + 
                "   <pubDate> date 1 </pubDate>\r\n" + 
                "</item>\r\n" + 
                "\r\n" + 
                "<item>\r\n" + 
                "   <title> this is title 2 </title>\r\n" + 
                "   <description> description 2 </description>\r\n" + 
                "   <pubDate> date 2 </pubDate>\r\n" + 
                "</item>";

        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
        for (Element item : doc.select("item")) {
            Elements children = item.children();
            for (Element child : children) {
                System.out.println(child.text());
            }
        }
    }
}
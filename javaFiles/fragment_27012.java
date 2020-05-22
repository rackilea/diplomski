public class Test {

    public static void main(String[] args) {
        try {
            String html = "<p id=\"Id44\">see the image and see the color... ?</p>\r\n" + "<p id=\"Id40\"></p>\r\n"
                    + "<div id=\"Id87\" style=\"display:inline-block\">\r\n"
                    + "<video id=\"Id30\" src=\"http://Id3.qa.cete.us/117973/video.mp4\"></video>\r\n" + "</div>\r\n"
                    + "<p id=\"Id28\"></p>\r\n" + "<p id=\"Id-1\"></p>\r\n" + "<div id =\"Id21\">\r\n"
                    + "<img id=\"img_44186\" src=\"/129884/apple.jpg\" />\r\n" + "</div>\r\n" + "<p id=\"Id-320046-3-21\"></p>";
            new Test().modifyMediaVariantContent(html);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modifyMediaVariantContent(String html) {
        org.jsoup.nodes.Document doc = Jsoup.parse(html);
        for (org.jsoup.nodes.Element element : doc.getElementsByTag("p")) {
            if (!element.hasText() && element.isBlock()) {
                element.remove();
            }
            if (element.hasText() && element.parent() == doc.body()) {
                Element replacment = new Element(Tag.valueOf("div"), "");
                replacment.appendChild(element.clone());
                element.replaceWith(replacment);
            }
        }

        System.out.println(doc.body().html());
    }
}
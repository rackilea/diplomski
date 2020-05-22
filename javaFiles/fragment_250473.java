import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        try {
            Pattern pattern = Pattern.compile("/(((?!/).)*)[.]");

            String html = "<!DOCTYPE HTML>" +
                            "<html>" +
                                "<head>" +
                                    "<title>Introduction</title>" +
                                "</head>" +
                                "<body> <article id=\"mobi_content\"> <h1 class=\"mobi-page-title\">\"Build Your Village\" Tool</h1> <section id=\"dataSectionInstanceId-431408\" class=\"body-text\"><p class=\"nonindent\">Your great career depends not only on you,</p> <p class=\"center\"><img src=\"mpla/multimedia/Cove_9781936111107_epub_005_r1.png\" id=\"mobi_image_12776\" class=\"inline-img\" alt=\"PNG\"/></p><p class=\"nonindent\">Sample deposits in the Emotional Bank Account:</p> <ul class=\"bullet\"> <li><p class=\"nonindent\">Congratulate the person on a job well done.</p></li> <li><p class=\"nonindent\">Send birthday greetings.</p></li></section></article></body>" +
                                "</html>";

            Document doc = Jsoup.parse(html);
            Elements imgs = doc.select("img");
            System.out.println(imgs);
            ListIterator<Element> iter = imgs.listIterator();
            while(iter.hasNext()) {
                Element img = iter.next();
                String src = img.attr("src");     
                Matcher matcher = pattern.matcher(src);
                if (matcher.find()) {
                    img.tagName("graphic").text(matcher.group(1)); 
                    removeAttr(img);
                }         
            }

            System.out.println(removeTags(doc.body().toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeAttr(Element e) {
        Attributes at = e.attributes();
        for (Attribute a : at) {
            e.removeAttr(a.getKey());
        }
    }

    public static String removeTags(String source) {    
        return source.replaceAll("(?!(</p>|<p .*?>|</?graphic>|</?i>|</?b>|<br/?>))(</?.*?>)", " ").trim();
    }
}
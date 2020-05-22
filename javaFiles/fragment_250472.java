import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {
        try {
            String html = "<!DOCTYPE HTML>" +
                            "<html>" +
                                "<head>" +
                                    "<title>Introduction</title>" +
                                "</head>" +
                                "<body> <article id=\"mobi_content\"> <h1 class=\"mobi-page-title\">\"Build Your Village\" Tool</h1> <section id=\"dataSectionInstanceId-431408\" class=\"body-text\"><p class=\"nonindent\">Your great career depends not only on you,</p> <p class=\"nonindent\">Sample deposits in the Emotional Bank Account:</p> <ul class=\"bullet\"> <li><p class=\"nonindent\">Congratulate the person on a job well done.</p></li> <li><p class=\"nonindent\">Send birthday greetings.</p></li></section></article></body>" +
                                "</html>";

            Document doc = Jsoup.parse(html);


            System.out.println(removeTags(doc.body().toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String removeTags(String source) {    
        return source.replaceAll("(?!(</p>|<p .*?>|</?i>|</?b>|<br/?>))(</?.*?>)", " ");
    }
}
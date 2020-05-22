package stack;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Stack {

    public static void main(String args[]) throws Exception {
        File input = new File("test.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements listofh3 = doc.getElementsByTag("h3");
        for(Element h3 : listofh3) {
            Element span = doc.createElement("span");
            span.addClass("block");

            Element cursor = h3;
            while(!cursor.tagName().equals("hr")) {
                Element next = cursor.nextElementSibling();
                span.appendChild(cursor);
                cursor = next;
            }
            cursor.remove(); //remove hr
            doc.body().appendChild(span);
        }

        System.out.println(doc);
    }
}
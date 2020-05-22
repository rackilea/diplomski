package stack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Stack {

    public static void main(String args[]) throws Exception {
        File input = new File("test.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        List<Elements> blocks = new ArrayList<>();

        Elements listofh3 = doc.getElementsByTag("h3");
        for(Element h3 : listofh3) {
            Elements block = new Elements();
            block.add(h3);
            Element cursor = h3;
            while(!cursor.tagName().equals("hr")) {
                cursor = cursor.nextElementSibling();
                block.add(cursor);
            }
            blocks.add(block);
        }

        for(Elements block : blocks) {
            System.out.println(block);
            System.out.println("----------------------------");
        }
    }
}
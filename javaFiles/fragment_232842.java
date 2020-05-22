import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SourceCodeProgram {

    public static void main(String[] args) throws Exception {
        System.out.println(PageParser.readAuthors("http://www.informatik.uni-trier.de/~ley/pers/hd/k/Kumar:G=_Praveen.htm"));
    }
}

class PageParser {
    public static List<List<String>> readAuthors(String url) throws Exception {
        Document document = Jsoup.connect(url).get();
        Elements elements = document.getElementsByClass("data");
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> authors = new ArrayList<String>();
        for (Element element : elements) {
            for (Element child : element.children()) {
                if ("title".equals(child.className())) {
                    result.add(authors);
                    authors = new ArrayList<String>();
                    break;
                }
                authors.add(child.html());
            }
        }
        return result;
    }
}
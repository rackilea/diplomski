import java.io.IOException;

import org.jsoup.Jsoup;

public class Test {

    public static void main(String args[]) throws IOException {

        String source = "<a class=\"context_link\" href=\"/thuc-don/41-Thit-vit-ram-sa-gung.html\">        <img src=\"http://monngonmoingay.com/uploads/monan/201205170430310000000_thit\" +                \"-vit-ram-sa-gung-48aq570.png\" alt=\"Th?t v?t ram s? g?ng \" />";
        String link = Jsoup.parse(source).select("a").first().attr("href");
        System.out.println("Your link  :" + link);

    }

}
import org.jsoup.Jsoup;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JSoupSO {

    @Test
    public void script() {
        String s = "<script>\n" +
                "_cUq=\"1lj9lodlnq\";\n" +
                "</script>";

        // let Jsoup parse the HTML
        String innerJavascript = Jsoup.parse(s).data();

        // remove all whitespaces
        innerJavascript = innerJavascript.replaceAll("\\s", "");

        assertThat(innerJavascript, is("_cUq=\"1lj9lodlnq\";"));
    }

}
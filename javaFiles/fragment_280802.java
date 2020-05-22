import static j2html.TagCreator.b;
import static j2html.TagCreator.p;
import static j2html.TagCreator.rawHtml;


public class HtmlTest
{
    public static void main(String[] args)
    {
        System.out.println(p(b("the bridge")));
        System.out.println(p(rawHtml("<b>the bridge</b>")));
    }

}
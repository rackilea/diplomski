import net.java.textilej.parser.MarkupParser;
import net.java.textilej.parser.builder.HtmlDocumentBuilder;
import net.java.textilej.parser.markup.mediawiki.MediaWikiDialect;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.StringReader;
import java.io.StringWriter;

public class Test {

    public static void main(String[] args) throws Exception {

        String markup = "This is ''italic'' and '''that''' is bold. \n"+
                "=Header 1=\n"+
                "a list: \n* item A \n* item B \n* item C";

        StringWriter writer = new StringWriter();

        HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer);
        builder.setEmitAsDocument(false);

        MarkupParser parser = new MarkupParser(new MediaWikiDialect());
        parser.setBuilder(builder);
        parser.parse(markup);

        final String html = writer.toString();
        final StringBuilder cleaned = new StringBuilder();

        HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {
                public void handleText(char[] data, int pos) {
                    cleaned.append(new String(data)).append(' ');
                }
        };
        new ParserDelegator().parse(new StringReader(html), callback, false);

        System.out.println(markup);
        System.out.println("---------------------------");
        System.out.println(html);
        System.out.println("---------------------------");
        System.out.println(cleaned);
    }
}
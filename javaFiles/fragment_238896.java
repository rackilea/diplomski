import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.Document;
...
public Document parseHtml(InputStream is) throws Exception {
    DOMParser parser = new DOMParser();
    parser.parse(new InputSource(is));
    return parser.getDocument();
}
import org.cyberneko.html.parsers.DOMParser;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import java.io.StringReader;

DOMParser parser = new DOMParser();
InputSource in = new InputSource(new StringReader(theHtmlString));
parser.parse(in);
Document doc = parser.getDocument();
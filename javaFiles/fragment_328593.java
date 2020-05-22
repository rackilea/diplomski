import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test {

  private static final String HTML_INSTRUCTIONS = "html_instructions";

  public static void main(String[] args) throws Exception {
    final List htmlInstructions = new ArrayList();

    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser sp = spf.newSAXParser();
    DefaultHandler dh = new DefaultHandler() {
      private boolean isHtmlInstructions = false;
      private StringBuilder sb = new StringBuilder();
      @Override
      public void startElement(String uri, String localName, String name,
          Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        if (HTML_INSTRUCTIONS.equals(name)) {
          isHtmlInstructions = true;
        }
      }

      @Override
      public void characters(char ch[], int start, int length)
      throws SAXException {
        if (isHtmlInstructions) {
          sb.append(ch, start, length);
        }
      }

      @Override
      public void endElement(String uri, String localName, String name)
          throws SAXException {
        super.endElement(uri, localName, name);
        if (HTML_INSTRUCTIONS.equals(name)) {
          htmlInstructions.add(sb.toString());
          sb.delete(0, sb.length());
          isHtmlInstructions = false;
        }
      }
    };

    InputStream is = new FileInputStream("test.xml");
    sp.parse(is, dh);
    for (String htmlInstruction : htmlInstructions) {
      System.out.println(htmlInstruction);
    }

  }

}
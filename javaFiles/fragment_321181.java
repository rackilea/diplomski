import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MySAXParser extends DefaultHandler {

    private List<Currency> currencies = new ArrayList<>();
    private Currency curr = null;
    private StringBuilder sb;

    public static void main(String[] args) {

        String url = "http://nbt.tj/en/kurs/export_xml.php?date=2016-08-01&export=xmlout";

        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);

            SAXParser sp = spf.newSAXParser();
            MySAXParser handler = new MySAXParser();

            sp.parse(new InputSource(url), handler);

            for (Currency curr : handler.getCurrencies()) {
                System.out.println(curr.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    @Override
    public void startElement(String s, String localName, String elementName, Attributes atts) throws SAXException {
        if (elementName.equalsIgnoreCase("valute")) {
            curr = new Currency();
            currencies.add(curr);
            curr.setCurrId(atts.getValue("ID"));
        } else if (elementName.equalsIgnoreCase("value") || elementName.equalsIgnoreCase("CharCode")) {
            sb = new StringBuilder();
        }
    }

    @Override
    public void endElement(String s, String localName, String elementName) throws SAXException {
        if (elementName.equalsIgnoreCase("value")) {
            curr.setRate(Double.parseDouble(sb.toString()));
            sb = null;
        }
        else if (elementName.equalsIgnoreCase("CharCode")) {
            curr.setCharCode(sb.toString());
            sb = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (sb != null) {
            sb.append(ch, start, length);
        }
    }

}
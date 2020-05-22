import java.io.IOException;
import java.io.Writer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.support.AbstractXMLOutputProcessor;
import org.jdom2.output.support.FormatStack;
import org.jdom2.output.support.XMLOutputProcessor;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;


public class JDOMEray {

    public static void main(String[] args) throws JDOMException, IOException {
        Document eray = new SAXBuilder().build("eray.xml");
        Namespace[] NAMESPACES = {Namespace.getNamespace("gl-cor", "http://www.xbrl.org/int/gl/cor/2006-10-25")};
        XPathExpression<Element> xpath = XPathFactory.instance().compile("gl-cor:entityInformation", Filters.element(), null, NAMESPACES);
        Element innerElement = xpath.evaluateFirst(eray.getRootElement());

        System.out.println(toString(innerElement));
    }

    private static final XMLOutputProcessor noNamespaces = new AbstractXMLOutputProcessor() {

        @Override
        protected void printNamespace(final Writer out, final FormatStack fstack, 
            final Namespace ns)  throws IOException {
            // do nothing with printing Namespaces....
        }

    };

    public static String toString(Element element) {
        Format format = Format.getPrettyFormat();
        format.setTextMode(Format.TextMode.NORMALIZE);
        format.setEncoding("UTF-8");

        XMLOutputter xmlOut = new XMLOutputter(noNamespaces); 
        xmlOut.setFormat(format);
        return xmlOut.outputString(element);
    }


}
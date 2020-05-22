import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class BarAdapter extends XmlAdapter<Object, Bar>{

    private DocumentBuilder documentBuilder;

    public BarAdapter() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();
        } catch(Exception e) {
            // TODO - Handle Exception
        }
    }

    @Override
    public Bar unmarshal(Object v) throws Exception {
        Bar bar = new Bar();
        Element element = (Element) v;
        bar.value = element.getTextContent();
        return bar;
    }

    @Override
    public Object marshal(Bar v) throws Exception {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("bar");
        root.setTextContent(v.value);
        return root;
    }

}
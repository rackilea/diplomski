import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class BarAdapter extends XmlAdapter<Object, Bar>{

    @Override
    public Object marshal(Bar bar) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Element element = document.createElementNS("http://www.example.com/BAR", "ns:bar");
        element.setTextContent(bar.getValue());
        return element;
    }

    @Override
    public Bar unmarshal(Object arg0) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
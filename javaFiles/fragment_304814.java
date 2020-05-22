package forum8198945;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class XMLStreamReaderWrapper extends StreamReaderDelegate {

    public XMLStreamReaderWrapper(XMLStreamReader xmlStreamReader) {
        super(xmlStreamReader);
    }

    @Override
    public String getAttributeNamespace(int index) {
        String attributeName = getAttributeLocalName(index);
        if("type".equals(attributeName) || "nil".equals(attributeName)) {
            return "http://www.w3.org/2001/XMLSchema-instance";
        }
        return super.getAttributeNamespace(index);
    }


}
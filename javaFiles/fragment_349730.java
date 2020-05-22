import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public String TransformDocumentToString(Document doc)
{
    DOMSource dom = new DOMSource(doc);
    StringWriter writer = new StringWriter();  
    StreamResult result = new StreamResult(writer);

    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer();
    transformer.transform(dom, result);

    return writer.toString();
}
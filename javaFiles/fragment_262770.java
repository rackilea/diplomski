import javax.xml.bind.JAXBContext;
import javax.xml.transform.dom.DOMResult;
import org.w3c.dom.Element;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

...

public static Element marshallToElement(Object data, Class clazz) {
        DOMResult res = null;
        try {
            JAXBContext ctx = JAXBContextManager.getInstance(clazz.getPackage().getName());
            Marshaller marshaller = ctx.createMarshaller();
            res = new DOMResult();
            marshaller.marshal(data, res);
        } catch (JAXBException e) {
            LOG.error(e);
        }
        return ((Document)res.getNode()).getDocumentElement();
    }
import java.io.File;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBHelper;
import org.eclipse.persistence.oxm.NamespaceResolver;
import org.opentravel.ota._2003._05.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("org.opentravel.ota._2003._05", ObjectFactory.class.getClassLoader(), null);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("input.xml");
        OTAHotelInvCountNotifRQ rq = (OTAHotelInvCountNotifRQ) unmarshaller.unmarshal(xml);

        NamespaceResolver nsResolver = new NamespaceResolver();
        nsResolver.put("ns", "http://www.opentravel.org/OTA/2003/05");

        InvCountType inventories = JAXBHelper.getJAXBContext(jc).getValueByXPath(rq, "ns:Inventories", nsResolver, InvCountType.class);
        System.out.println(inventories);
    }

}
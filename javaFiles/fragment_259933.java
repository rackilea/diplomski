package forum13408684;

import javax.xml.bind.*;
import forum13408684.a.A;
import forum13408684.b.B;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(A.class, B.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new A(), System.out);
        marshaller.marshal(new B(), System.out);
    }

}
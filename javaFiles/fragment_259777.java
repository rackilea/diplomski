package forum11796699;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Value.class);

        Value value = new Value();
        value.setValue(null);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(value, System.out);
    }

}
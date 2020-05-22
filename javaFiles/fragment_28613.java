package test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(A.class, B.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        A a = new A();
        DataA da = new DataA();
        da.string1 = "1";
        da.string2 = "2";
        a.setSource(da);
        marshaller.marshal(a, System.out);

        B b = new B();
        DataB db = new DataB();
        db.string1 = "1";
        db.string2 = "2";
        db.string3 = "3";
        b.setSource(db);
        marshaller.marshal(b, System.out);
    }
}
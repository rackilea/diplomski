package com.test;

import java.io.StringWriter;
import javax.xml.bind.*;

public class main {

    /**
     * @param args
     */

    public static void main(String[] args) {

        IInterface1 i1 = new Interface1Impl();
        i1.setA("SET A VALUE");
        i1.setB("Set B VALUE");
        IInterface2 i2 = new Interface2Impl();
        i2.setC("X");
        i2.setD("Y");
        i1.getI2().put("SOMVAL", i2);

        String retval = null;
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Interface1Impl.class,
                    Interface2Impl.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(i1, writer);
            retval = writer.toString();
        } catch (JAXBException ex) {
            // TODO: Log the error here!
            retval = ex.toString();
        }
        System.out.println(retval);

    }
}
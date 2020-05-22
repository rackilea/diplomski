package org.mylib;

import org.mylib.schema.Dataschema;
import org.mylib.schema.DelimitedDataSchema;
import org.mylib.schema.FixedWidthDataSchema;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.Reader;
import java.io.StringReader;

public class Main {

    public static void main(String[] args) throws Exception {
        Dataschema ds = null;

        Reader xmlFileDelimited = new StringReader("<dataschema>\n" +
                "  <delimited>\n" +
                "    <locale language=\"en\" country=\"us\" />\n" +
                "  </delimited>\n" +
                "</dataschema>");

        try {
            JAXBContext jc = JAXBContext.newInstance(Dataschema.class);
            Unmarshaller um = jc.createUnmarshaller();
            ds = (Dataschema) um.unmarshal(new StreamSource(xmlFileDelimited));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (ds == null) {
            throw new NullPointerException("null literal as output of marshaller!");
        }

        DelimitedDataSchema delimited = ds.getDelimited();
        FixedWidthDataSchema fixedwidth = ds.getFixedwidth();

        if (((fixedwidth == null) && (delimited == null)) || ((fixedwidth != null) && (delimited != null))) {
            throw new IllegalStateException("schemas cannot be both absent or be both present at the same time!"); // (because of <choice> xml schema)!
        }

        if (delimited != null) {
            // very primitive code for proving correctness
            System.out.println(delimited.getLocale().toString());
        }

        if (fixedwidth != null) {
            // very primitive code for proving correctness
            System.out.println(fixedwidth.getLocale().toString());
        }
    }
}
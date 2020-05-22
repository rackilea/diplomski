import java.io.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        OutputStream stream = System.out;

        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(stream);

        xsw.writeStartDocument();
        xsw.writeStartElement("foo");
        xsw.writeStartElement("bar");

        /* Following line is very important, without it unescaped data 
           will appear inside the <bar> tag. */
        xsw.writeCharacters("");
        xsw.flush();

        OutputStreamWriter osw = new OutputStreamWriter(stream);
        osw.write("<baz>Hello World<baz>");
        osw.flush();

        xsw.writeEndElement();
        xsw.writeEndElement();
        xsw.writeEndDocument();
        xsw.close();
    }

}
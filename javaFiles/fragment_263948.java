import java.io.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.CharacterEscapeHandler;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Foo foo = new Foo();
        foo.setBar("\"Hello World\"");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foo, System.out);

        marshaller.setProperty(MarshallerProperties.CHARACTER_ESCAPE_HANDLER, new CharacterEscapeHandler() {

            @Override
            public void escape(char[] buffer, int start, int length,
                    boolean isAttributeValue, Writer out) throws IOException {
                out.write(buffer, start, length);
            }

        });

        marshaller.marshal(foo, System.out);
    }

}
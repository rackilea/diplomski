import java.io.*;
import javax.xml.bind.*;

public class _Run {

  public static void main(String[] args)
      throws Exception {
    JAXBContext context = JAXBContext.newInstance(Bindings.ALL_CLASSES);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    Bindings.RawRepository adapter = new Bindings.RawRepository("myZipVFS");
    marshaller.setAdapter(adapter);

    Bindings.RawRef ta1 = new Bindings.RawRef();
    ta1.raw = "THIS IS A STRING".getBytes();
    Bindings.RawRef ta2 = new Bindings.RawRef();
    ta2.raw = "THIS IS AN OTHER STRING".getBytes();

    Bindings.Root root = new Bindings.Root();
    root.element.add(ta1);
    root.element.add(ta2);

    StringWriter out = new StringWriter();
    marshaller.marshal(root, out);

    System.out.println(out.toString());
  }

}
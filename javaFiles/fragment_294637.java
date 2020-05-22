import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Bar bar = new Bar();
        bar.setValue("Hello World");
        Foo foo = new Foo();
        foo.setBar(bar);

        Marshaller marshaller = jc.createMarshaller();

        // Marshal First Time to Get Namespace Declarations
        NsContentHandler contentHandler = new NsContentHandler();
        marshaller.marshal(foo, contentHandler);

        // Marshal Second Time for Real
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespacePrefixMapper(contentHandler.getNamespaces()));
        marshaller.marshal(foo, System.out);
    }

}
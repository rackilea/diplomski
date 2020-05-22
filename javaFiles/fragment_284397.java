import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Root rootA = new Root();
        rootA.setName("A");

        Root rootB = new Root();
        rootB.setName("B");
        rootA.setChild(rootB);

        Root rootC = new Root();
        rootC.setName("C");
        rootB.setChild(rootC);

        Root rootD = new Root();
        rootD.setName("D");
        rootC.setChild(rootD);

        Root rootE = new Root();
        rootE.setName("E");
        rootD.setChild(rootE);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        DepthListener depthListener = new DepthListener(3);
        marshaller.setListener(depthListener);
        marshaller.setAdapter(new RootAdapter(depthListener));
        marshaller.marshal(rootA, System.out);
    }

}
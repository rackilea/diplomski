package forum11340316;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(BarX.class, BarY.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        BarX barX = new BarX();
        barX.setXThing("XThing");
        marshaller.marshal(barX, System.out);

        BarY barY = new BarY();
        barY.setYBlah("YBlah");
        marshaller.marshal(barY, System.out);
    }

}
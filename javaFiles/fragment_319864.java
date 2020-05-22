package anotherTest;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Example {
    public static void main(String[] args) {

        // create container with list
        MyContainer container = new MyContainer();

        // add objects
        MyObject object;

        object = new MyObject();
        object.setChallongeApiKey("ABCABC");
        container.getChildren().add(object);

        PlayerProfile p = new PlayerProfile();
        p.setPlayerId(1);
        p.setPlayersStatus("unrated");

        List<PlayerProfile> l = new ArrayList<>();
        l.add(0, p);

        object.setPlayers(l);

        // marshal
        String baseXml = marshal(container);

        // unmarshal
        container = unmarshal(baseXml);

        System.out.println("unmarshal test: " + container.getChildren().get(0).getChallongeApiKey());
        System.out.println("unmarshal test: " + container.getChildren().get(0).getPlayer().get(0).getPlayerId());
        System.out.println("unmarshal test: " + container.getChildren().get(0).getPlayer().get(0).getPlayersStatus());

        System.exit(0);
    }

    public static String marshal(MyContainer base) {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MyContainer.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(base, stringWriter);
            String xml = stringWriter.toString();

            System.out.println("XML:\n" + xml);

            return xml;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static MyContainer unmarshal(String xml) {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MyContainer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(xml);

            MyContainer container = (MyContainer) jaxbUnmarshaller.unmarshal(stringReader);

            return container;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
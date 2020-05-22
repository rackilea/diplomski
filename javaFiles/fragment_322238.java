import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(TaskList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum16579050/input.xml");
        TaskList taskList = (TaskList) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(taskList, System.out);
    }

}
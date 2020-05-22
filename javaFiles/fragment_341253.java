import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.example.test.CheckLog;
import com.example.test.Ping;
import com.example.test.Test;

public class Test8 {
    public static void main(String[] args) throws Exception {
        Test root = new Test();
        root.setTestTitle("My title");
        root.getFoo().add(newPing("ping 1"));
        root.getFoo().add(newCheckLog("check log 1"));
        root.getFoo().add(newPing("ping 2"));

        JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(root, System.out);
    }
    private static Ping newPing(String action) {
        Ping obj = new Ping();
        obj.setAction(action);
        return obj;
    }
    private static CheckLog newCheckLog(String action) {
        CheckLog obj = new CheckLog();
        obj.setAction(action);
        return obj;
    }
}
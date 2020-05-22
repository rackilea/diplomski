import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Test {

    public static void main(String[] args) throws Exception {
        JAXBContext ctx = JAXBContext.newInstance(Root.class);
        Unmarshaller um = ctx.createUnmarshaller();
        Root root = (Root) um.unmarshal(new File("test.xml"));
        // XML is now loaded. Turn it into a Map
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (Data data : root.data) {
            map.put(data.name, data.column);
        }
        System.out.println(map);    // Easily show content
    }
}
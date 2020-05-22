import java.io.FileInputStream;
import javax.xml.bind.JAXB;

public class importFromXml {

    public Relation ReadDbNow() throws Exception {
        return JAXB
                .unmarshal(new FileInputStream("test.xml"), Relation.class);
    }
}
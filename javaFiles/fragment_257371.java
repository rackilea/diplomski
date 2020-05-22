import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(A.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        A a = (A) unmarshaller.unmarshal(new StringReader("<a><B/></a>"));

        System.out.println(a.getB());
        System.out.println(a.getC());
    }

}
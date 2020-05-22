import javax.xml.bind.*;
import java.io.*;
import test.*;

public class Test {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(MyElem.class);
            Unmarshaller u = jc.createUnmarshaller();
            Object o = u.unmarshal( new File( "test.xml" ) );   
            System.out.println(((MyElem)o).isRequired());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
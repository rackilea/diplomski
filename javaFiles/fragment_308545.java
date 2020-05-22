import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MyClass")
public class MyClass {
    public static MyClass myClass = new MyClass();

    public static int variable1 = 0;
    public static int variable2 = 0;
    public static int variable3 = 0;

    public final Object constant1 = 5;

    @XmlElement
    public int getVariable1() {
        return variable1;
    }

    public void setVariable1(int variable1) {
        MyClass.variable1 = variable1;
    }

    @XmlElement
    public int getVariable2() {
        return variable2;
    }

    public void setVariable2(int variable2) {
        MyClass.variable2 = variable2;
    }

    @XmlElement
    public int getVariable3() {
        return variable3;
    }

    public void setVariable3(int variable3) {
        MyClass.variable3 = variable3;
    }

    public static void main(String[] args) throws JAXBException {
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<MyClass>\n"
                + "<variable1>1</variable1>\n"
                + "<variable2>2</variable2>\n"
                + "<variable3>3</variable3>\n"
                + "</MyClass>";

        JAXBContext context = JAXBContext.newInstance(MyClass.class);
        Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

        MyClass.myClass = (MyClass) jaxbUnmarshaller.unmarshal(new StringReader(data));

        System.out.println(MyClass.variable1);
        System.out.println(MyClass.variable2);
        System.out.println(MyClass.variable3);

        System.out.println(MyClass.myClass.variable1);
        System.out.println(MyClass.myClass.variable2);
        System.out.println(MyClass.myClass.variable3);
    }
}
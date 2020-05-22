import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class TestCustomAttribute {
  public static void main(String[] args) throws Exception {
    List<Value> valueList = new ArrayList<>();
    Value value1 = new Value();
    value1.setData("Green");
    valueList.add(value1);

    Value value2 = new Value();
    value2.setData("Red");
    valueList.add(value2);

    CustomAttribute ca = new CustomAttribute();
    ca.setValue(valueList);

    JAXBContext jaxbContext = JAXBContext.newInstance(CustomAttribute.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    // output pretty printed
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    jaxbMarshaller.marshal(ca, System.out);
  }
}
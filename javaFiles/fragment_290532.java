import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Customer")
public class JaxBExample {
     int id;
     String name;
     int age;
    //SETTERS AND GETTERS
    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "JaxBExample [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customers")
@XmlAccessorType (XmlAccessType.NONE)
public class TestList implements Serializable {

    private List<JaxBExample> Customers=null;

    public List<JaxBExample> getCustomers() {
        return Customers;
    }
     @XmlElement
    public void setCustomers(List<JaxBExample> customers) {
        Customers = customers;
    }
    @Override
    public String toString() {
        return "TestList [Customers=" + Customers + "]";
    }
}


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class ConvertObj2XML {

public static void main(String args[]){

    JaxBExample customer=new JaxBExample();
    customer.setId(1);
    customer.setName("Raghava");
    customer.setAge(26);
    System.out.println("OBJ "+customer);

    JaxBExample customer1=new JaxBExample();
    customer1.setId(2);
    customer1.setName("mani");
    customer1.setAge(26);
    System.out.println("OBJ "+customer1);
    List<JaxBExample> customerLst=new ArrayList<JaxBExample>();
    customerLst.add(customer);
    customerLst.add(customer1);
    TestList customers=new TestList();
    customers.setCustomers(customerLst);
    System.out.println(customers.toString());

    try {
        File file = new File("E:\\file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(TestList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(customers, file);
        jaxbMarshaller.marshal(customers, System.out);

          } catch (JAXBException e) {
        e.printStackTrace();
          }
}
}

OBJ JaxBExample [id=1, name=Raghava, age=26]
    OBJ JaxBExample [id=2, name=mani, age=26]
    TestList [Customers=[JaxBExample [id=1, name=Raghava, age=26], JaxBExample [id=2, name=mani, age=26]]]
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <Customers>
    <customers id="1">
        <age>26</age>
        <name>Raghava</name>
    </customers>
    <customers id="2">
        <age>26</age>
        <name>mani</name>
    </customers>
</Customers>
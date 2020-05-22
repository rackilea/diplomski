import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ObjectWithList {

  private MyList myList;

  @XmlElement(name = "MyList")
  public MyList getMyList() {
    return myList;
  }

  public void setMyList(MyList myList) {
    this.myList = myList;
  }

  @Override
  public String toString() {
    return "ObjectWithList{" + "myList=" + myList + '}';
  }
}



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MyList")
public class MyList {

  private String abc;

  private List<String> list;

  @XmlElement(name = "abc")
  public String getAbc() {
    return abc;
  }

  public void setAbc(String abc) {
    this.abc = abc;
  }

  @XmlElement(name = "list")
  public List<String> getList() {
    return list;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "MyList{" + "abc='" + abc + '\'' + ", list=" + list + '}';
  }
}



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Test {
  public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ObjectWithList.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    ObjectWithList emps =
        (ObjectWithList)
            jaxbUnmarshaller.unmarshal(
                new File("D:/someFolder/emp.xml"));
    for (String s : emps.getMyList().getList()) {
      System.out.println(s);
    }
    System.out.println(emps);
    System.out.println(" ");
  }
}
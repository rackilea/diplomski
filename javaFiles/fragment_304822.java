@XmlRootElement
public class Person {

    @XmlElement(name = "Name")
    String name;

    @XmlElement(name = "Age")
    int age;
}

@XmlRootElement
public class Header {    
}

@XmlRootElement
public class Document {

    @XmlElement(name = "Header")
    Header header;

    @XmlElementWrapper(name = "Whatever")
    @XmlElement(name = "person")
    List<Person> people;
}
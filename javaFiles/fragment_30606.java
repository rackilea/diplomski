@XmlRootElement(name = "Main")
public class Main {
    @XmlElementWrapper(name = "MyFirstClasses")
    @XmlElement(name = "MyFirstClass")
    private List<MyFirstClass> myFirstClass;
}
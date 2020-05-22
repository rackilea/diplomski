@XmlRootElement(name = "greetings")
public class RootClass {

    @XmlElement(name = "greeting")
    public List<TestClassForSo> greetingList;

}
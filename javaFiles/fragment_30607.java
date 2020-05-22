@XmlAccessorType(XmlAccessType.FIELD)
public class MyFirstClass {
    private int num;
    @XmlElement(name = "MySecondClass")
    private MySecondClass mySecondClass;
}
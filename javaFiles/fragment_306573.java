@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"param1", "param2", "param3"})
public class Demo{

public Demo() {
}

private int param1;
private String param2;
private String param3;

//getter & setters without annotations

}
@XmlRootElement
public class MainTest {

  private TestElement el1

  private TestElement el2
  ...

  @XmlElement(name="TestElement")
  private Field getFieldEl1() {
    return el1.getField();
}
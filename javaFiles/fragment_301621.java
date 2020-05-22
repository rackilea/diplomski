@XmlRootElement
public class Anything {
  private Object any;

  @XmlAnyElement
  public Object getAny() { return any; }
  public void setAny(Object any) { this.any = any; }

  public static void main(String[] args) throws DOMException,
      ParserConfigurationException {
    Element foo = DocumentBuilderFactory.newInstance()
        .newDocumentBuilder()
        .newDocument()
        .createElement("foo");
    Anything a = new Anything();
    a.setAny(foo);
    JAXB.marshal(a, System.out);
  }
}
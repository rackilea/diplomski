public class Adapter extends XmlAdapter<String, String> {
  @Override
  public String marshal(String s) throws Exception {
    return "_" + s;
  }
  @Override
  public String unmarshal(String v) throws Exception {
    return v.substring(1);
  }
}
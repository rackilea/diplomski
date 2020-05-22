public MyDto postJSON(MyDto dto) {
  //do something
  MyDto md = new MyDto();
  return md;
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MyDto {
  private String f1;
  private int f2;
  //etc.
}
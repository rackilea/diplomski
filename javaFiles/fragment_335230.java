import javax.xml.bind.annotation.XmlValue;

public class Value {

  private String data;

  @XmlValue
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
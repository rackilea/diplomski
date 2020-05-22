package test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="root")
public class B extends A {

  private StringBuffer source = null;

  public String getSource() {
    return source.toString();
  }

  public void setSource(String source) {
    this.source = new StringBuffer(source);
  }
}
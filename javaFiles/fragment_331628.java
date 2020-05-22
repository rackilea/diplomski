import org.eclipse.persistence.oxm.annotations.XmlTransformation;
import org.eclipse.persistence.oxm.annotations.XmlWriteTransformer;

@XmlRootElement
public static class MyClass {
  @XmlAttribute
  @XmlReadTransformer(transformerClass=FixedFloatingTransformer.class)
  @XmlWriteTransformer(xmlPath="@f", transformerClass=FixedFloatingTransformer.class)
  private double f; //[0-1]

  public double getF() {
    return f;
  }
}
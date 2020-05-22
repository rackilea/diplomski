@XmlRootElement(name="foo")
@XmlType(name="foo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bar {

    @XmlElement(name="fooProp")
    private String barProp;

}
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametre")
public class Parametre {
    List<Param> params;
}

@XmlType(name = "param")
public class Param {
    @XmlAttribute(name = "required")
    String name;
    String value;
}
@XmlType(name = "StatoPratica")
@XmlEnum
public enum StatoPratica {
    @XmlEnumValue(value = "Awesome")
    A, 
    @XmlEnumValue(value = "Better")
    B;
}
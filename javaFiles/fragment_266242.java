@XmlType(name = "status")
@XmlEnum
public enum Status {
    @XmlEnumValue(value = "successful")
    SUCESSFUL, 
    @XmlEnumValue(value = "error")
    ERROR;
}
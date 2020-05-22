@XmlType(name = "TrailerType")
@XmlEnum
public enum TrailerType {

    _20FT,
    OTHR;

    public String value() {
        return name();
    }

    public static TrailerType fromValue(String v) {
        return valueOf(v);
    }

}
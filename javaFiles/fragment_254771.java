@XmlType(name = "TrailerType")
@XmlEnum
public enum TrailerType {

    @XmlEnumValue("_20FT")
    VALUE_1("_20FT"),
    @XmlEnumValue("OTHR")
    VALUE_2("OTHR");
    private final String value;

    TrailerType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrailerType fromValue(String v) {
        for (TrailerType c: TrailerType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
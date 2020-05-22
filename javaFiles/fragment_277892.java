/**
 * <p>Java class for requestStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="requestStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHIPPED"/>
 *     &lt;enumeration value="PENDING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "requestStatus")
@XmlEnum
public enum RequestStatus {

    SHIPPED,
    PENDING;

    public String value() {
        return name();
    }

    public static RequestStatus fromValue(String v) {
        return valueOf(v);
    }

}
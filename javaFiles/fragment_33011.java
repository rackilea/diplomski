import com.thoughtworks.xstream.annotations.*;

@XStreamAlias("person")
public class Person {

    private String firstname;
    private String lastname;

    @XStreamConverter(ValueAttributeConverter.class)
    private String phone;

    @XStreamConverter(ValueAttributeConverter.class)
    private String fax;

    // add appropriate constructor(s)

    /** For testing purposes - not required by XStream itself */
    public String toString() {
      return "fn: " + firstname + ", ln: " + lastname +
             ", p: " + phone + ", f: " + fax;
    }
}
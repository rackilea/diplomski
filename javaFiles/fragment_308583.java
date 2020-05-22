@XmlType(name = "MyEnum")
@XmlEnum
public enum MyEnum {


    /**
     * 
     *                         This is a comment.
     *                     
     * 
     */
    STANDARD,

    public String value() {
        return name();
    }

    public static MyEnum fromValue(String v) {
        return valueOf(v);
    }

}
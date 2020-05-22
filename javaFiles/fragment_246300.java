@XmlRootElement(name="db")
public class Db {
    @XmlElement(required=true) private Type1 type1;
    @XmlElement(required=true) private Type2 type2;
}

public class Type1 {
    @XmlElement(required=true ) private String data1;
    @XmlElement(required=false) private String data2;
    @XmlElement(required=true ) private String data3;
    @XmlElement(required=false) private String data4;
    @XmlElement(required=true ) private String data5;
    @XmlElement(required=false) private String data6;
    @XmlElement(required=false) private String data7;
}

public class Type2 {
    @XmlElement(required=true ) private String meta1;
    @XmlElement(required=false) private String meta2;
    @XmlElement(required=false) private String meta3;
    @XmlElement(required=true ) private String meta4;
    @XmlElement(required=false) private String meta5;
    @XmlElement(required=true ) private String meta6;
    @XmlElement(required=false) private String meta7;
    @XmlElement(required=false) private String meta8;
    @XmlElement(required=false) private String meta9;
}
@XmlRootElement(name = "GTSResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public static class GTSResponse {

    @XmlElement(name = "Record")
    List<Record> records;
}

@XmlRootElement(name = "Record")
@XmlAccessorType(XmlAccessType.FIELD)
public static class Record {

    @XmlElement(name = "Field")
    List<Field> fields;

}

@XmlRootElement(name = "Field")
@XmlAccessorType(XmlAccessType.FIELD)
public static class Field {

    @XmlAttribute(name = "name")
    String name;
    @XmlAttribute(name = "primaryKey")
    boolean primaryKey;

    @XmlValue
    String data;
}
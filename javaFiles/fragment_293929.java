@XmlRootElement
public class Customer {
    @XmlElement
    public AddressMap addressMap;
}

public class AddressMap {
    @XmlElement
    public List<Column> col;
}

public class Column {
    @XmlAttribute
    public String key;
    @XmlValue
    public String value;
}
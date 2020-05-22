This Code Would work 

@XmlRootElement(name = "Details")
@XmlAccessorType(XmlAccessType.FIELD)
class Details
{
    @XmlElement(name = "Uniqueno")
    String Uniqueno;   


    @XmlElement(name = "ROWSET")
    private Persons[] persons;

    // setters & getters
}

@XmlRootElement(name = "ROWSET")
@XmlAccessorType(XmlAccessType.FIELD)
class Persons
{
    @XmlAttribute
    String name;

    @XmlElement(name = "ROW")
    private Row[] rows;


    // setters & getters
}

@XmlRootElement(name = "ROW")
@XmlAccessorType(XmlAccessType.FIELD)
class Row
{

    @XmlAttribute
    String num;

    @XmlElement
    String Name;

    @XmlElement
    String Age;

    // setters & getters
}
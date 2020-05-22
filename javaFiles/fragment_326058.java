@XmlRootElement(name = "Identification_List")
@XmlAccessorType(XmlAccessType.FIELD)
public class IdentificationList {

    @XmlAttribute
    private int counter;

    @XmlElement(name = "Identification")
    private List<Identification> identifications;

    // getters and setters
}

@XmlAccessorType(XmlAccessType.FIELD)
public class Identification {

    @XmlAttribute
    private int number;

    @XmlAttribute
    private char letter;

    @XmlAttribute
    private String name;

    @XmlElementWrapper(name = "TravelList")
    @XmlElement(name = "Travel")
    private List<Travel> travels;

    // getters and setters
}

@XmlAccessorType(XmlAccessType.FIELD)
public class Travel {

    @XmlAttribute
    private String travelType;

    // getters and setters
}
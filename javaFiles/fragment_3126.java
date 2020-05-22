package cars;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    String brand;
    @XmlElementRef
    Engine engine;
}

@XmlRootElement
abstract class Engine {
}

@XmlRootElement(name = "v12engine")
@XmlAccessorType(XmlAccessType.FIELD)
class V12Engine extends Engine {
    @XmlAttribute
    int horsePowers;
}

@XmlRootElement(name = "v6engine")
@XmlAccessorType(XmlAccessType.FIELD)
class V6Engine extends Engine {
    // override the default attribute name, which would be fuelType
    @XmlAttribute(name = "fuel")
    String fuelType;
}
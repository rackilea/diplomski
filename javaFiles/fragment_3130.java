@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlJavaTypeAdapter(BrandAdapter.class)
    String brand;
    @XmlElementRef
    Engine engine;
}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TestTO", namespace="test/common")
public abstract class TestTO {

    @XmlJavaTypeAdapter(MapAdapter.class)
    private Map<String, Object> elements;
}
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "PS", namespace = "financetypes:defn:v4")
    protected financetypes.v4.PSType pS;
    @XmlElement(name = "PS", namespace = "financetypes:defn:v5")
    protected financetypes.v5.PSType pSV5;
}
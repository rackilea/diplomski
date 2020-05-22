@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Container {
    private List<Item> order;
    @XmlElement
    public List<Item> getOrder(){
        if( order == null ){
            order = new ArrayList<>();
        }
        return order;
    }
}
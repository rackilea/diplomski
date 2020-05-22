@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Letters {
    List<A> list;

    @XmlElementRef
    public List<A> getList() {
        return list;
    }

    public void setList(List<A> list) {
        this.list = list;
    }
}
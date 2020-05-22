@XmlRootElement(name="a")
public class A {
    private List<B> bs;

    @XmlElement(name="b")
    public List<B> getBs(){
        if( bs == null ){
            bs = new ArrayList<>();
        }
        return bs;
    }
}
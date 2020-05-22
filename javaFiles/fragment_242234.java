@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root{ // Training
    @XmlElement
    private A a;  // Brochure
    public Root(){}
    public A getA(){ return a; }
    public void setA( A value ){ a = value; }
}

@XmlJavaTypeAdapter(AFormatter.class)
public class A{  // Brochure
    private Collection<B> bees;
    public A(){
        bees = new ArrayList<>();
    }
    public Collection<B> getBees() {
        if( bees == null ) bees = new ArrayList<>();
        return bees;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
public class B{  // Course
    @XmlElement
    private String id;
    public B(){}
    public String getId(){ return id; }
    public void setId( String value ){ id = value; }
}

public class AFormatter extends XmlAdapter<BeeHive, A>{
    @Override
    public A unmarshal(BeeHive v) throws Exception {
        A a = new A();
        for( B b: v.beeList ){
            a.getBees().add( b );
        }
        return a;
    }
    @Override
    public BeeHive marshal(A v) throws Exception {
    BeeHive beeHive = new BeeHive();
        for( B b: v.getBees() ){
             if( b.getId().startsWith("a") ) beeHive.beeList.add( b ); 
        }                              
        return beeHive;
    }
}

public class BeeHive { // Courses
    @XmlElement(name="b")
    public List<B> beeList = new ArrayList<B>();
}
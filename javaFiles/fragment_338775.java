@XmlRootElement
public class A implements Serializable {
    private String name;

    // ...
}

@XmlRootElement
public class C extends A {

    @Override
    @XmlTransient
    public String getName() {
        return super.getName();
    }
}
@Entity
@Table(name = "foo")
@XmlRootElement
public class Foo implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fooId")
    private Collection<FooAttribute> fooAttributeCollection;

    @XmlID
    //If you want to use anything other than a String, you may need
    //to write your own adapter
    @XmlJavaTypeAdapter(value=MyCusomIntegerAdapter.class)
    public Integer getFoodID(){ ... }

    public Collection<FooAttribute> getFooAttributeCollection() {
        return fooAttributeCollection;
    }

    public void setFooAttributeCollection(Collection<FooAttribute> fooAttributeCollection) {
        this.fooAttributeCollection = fooAttributeCollection;
    }
}

@Entity
@Table(name = "foo_attribute")
@XmlRootElement   
public class FooAttribute implements Serializable {
    @JoinColumn(name = "foo_id", referencedColumnName = "foo_id")
    @ManyToOne(optional = false)
    private Study fooId;

    @XmlIDREF
    public Foo getFooId() {
        return this.fooId;
    }
    public void setFooId(Foo f) {
        this.fooId = f;
    }
}
public class A {

    @XmlElementRef
    public Foo getFoo() {
        return foo;
    }

    @XmlTransient
    public SomeObject getSomeObject() {
        return foo.getSomeObject();
    }

}
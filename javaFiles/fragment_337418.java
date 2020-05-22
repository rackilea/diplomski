@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TestRoot")
public static class RootElement {
    @XmlElement(name = "SomeDate")
    private Date dt = new Date();

    @XmlAnyElement(lax=true)
    private A a = new C();
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TestA")
@XmlType
public static abstract class A {
    private int fld1 = 1;

    @XmlAnyElement(lax=true)
    @XmlElementWrapper
    protected List<Object> list = new ArrayList<>();
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TestC")
public static class C extends A {
    private int fld2  = 3;
}
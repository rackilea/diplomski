interface Foo {}

class Bar implements Foo {}

class Baz implements Foo {}

@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.FIELD)
class FooContainer {
    @XmlElements({
        @XmlElement(name = "bar", type = Bar.class),
        @XmlElement(name = "baz", type = Baz.class)
    })
    private List<Foo> foos;

    FooContainer() {}

    FooContainer(List<Foo> foos) {
        this.foos = foos;
    }

    public List<Foo> getFoos() {
        return foos;
    }
}
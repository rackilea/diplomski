@ApplicationScoped
public class SomeFactory {

    @Produces
    public SomeBean produceSome() {
        return new SomeBean();
    }
}

@RequestScoped   // bug, redundant definition
public class SomeBean {
}
@Named
@RequestScoped
public class Bean {

    @PostConstruct
    public void init() {
        // ...
    }

    @Named
    @Produces
    public SomeObject getSomeObject() {
        // ...
    }

}
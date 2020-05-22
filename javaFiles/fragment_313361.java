@ManagedBean
@RequestScoped
public class Bean {

    private String data;

    @EJB
    private SomeService service;

    @PostConstruct
    public void init() {
        data = service.load();
    }

    // Getter.
}
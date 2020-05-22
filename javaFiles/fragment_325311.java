@Stateless
public class GreeterEjb {

    private final Greeter greeter;


    @Inject
    public GreeterEjb(Greeter greeter) {
        this.greeter = greeter;
    }


    // public no-arg constructor required for EJBs
    // injection still works fine with the @Inject constructor
    public GreeterEjb() {
        this.greeter = null;
    }


    public String greet() {
        return greeter.greet();
    }
}
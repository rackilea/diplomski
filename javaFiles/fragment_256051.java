@ManagedBean
@RequestScoped
public class Bean {

    private String foo;

    public void submit() {
        // Here, you're inside the action method!
        // Save foo in DB or something: someService.save(foo);
        // Navigate to a different view if necessary.
    }

    // Getter+setter.
}
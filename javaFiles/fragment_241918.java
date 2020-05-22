@ManagedBean("manageAccountController")
@SessionScoped
public class ControllerA implements Serializable{

    @ManagedProperty("#{controllerB}")
    private ControllerB details;

    public ControllerB getDetails() {
        return details;
    }

    public void setDetails(ControllerB details) {
        this.details = details;
    }

}
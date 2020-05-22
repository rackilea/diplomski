@ManagedBean
@SessionScoped
public class ControllerBean {

    private String aString = "session wide value for a string";
    // Non-static getter and setter for aString.

    // ...
}

@ManagedBean
@ViewScoped
public class OneRandomViewScopedBean {

    @ManagedProperty("#{controllerBean}")
    private ControllerBean controllerBean;
    // Setter for controllerBean. Getter is not mandatory.

    public void someAction() {
        controllerBean.setAString(newValueForString);
    }

    // ...
}
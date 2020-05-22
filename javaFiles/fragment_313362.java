@ManagedBean
@ViewScoped
public class Bean {

    private String selectedItem;
    private String result;

    @EJB
    private SomeService service;

    public void changeSelectedItem(AjaxBehaviorEvent event) {
        result = service.find(selectedItem);
    }

    // Getters+setter.
}
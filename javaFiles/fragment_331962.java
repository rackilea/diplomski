@ManagedBean
@ViewScoped
public class Bean {

    private Map<String, String> selectedItems = new HashMap<String, String>();

    public Map<String, String> getSelectedItems() {
        return selectedItems;
    }

    // ...
}
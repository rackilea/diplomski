@ManagedBean
@ViewScoped
public class YourMB {
    private List<Elem> dataList;

    @PostConstruct
    public void init() {
        // initialize dataList here
    }
    public void editAction(Elem e) {
        e.setEditable(true);
    }
    public void saveAction() {
        // do your thing here to update in the database,
        // and then reset the editable property for all items:
        for (Elem e : dataList) {
            e.setEditable(false);
        }
    }
    // getters and setters...
}
@ManagedBean
public class DataTableBacking {

    String[] items = {"A", "B"};

    public String[] getItems() {
        return items;
    }

    public void action(String action) {
        System.out.println("Action called with:" + action);
    }

}
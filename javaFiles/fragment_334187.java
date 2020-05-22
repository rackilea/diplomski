@ManagedBean
public class DataTableBacking {

    Department[] items = {new Department(), new Department()};

    public Department[] getItems() {
        return items;
    }

    public void action(Department action) {
        System.out.println("Action called with:" + action);
    }

}
public final class DataStorage {
    private List<Employee> empList = new ArrayList<Employee>();
    private List<Manager> managerList = new ArrayList<Manager>();
    private List<Dish> allDishes = new ArrayList<Dish>();
    private List<Table> allTables = new ArrayList<Table>();
    private Inventory inventory = null;

    private static DataStorage _instance = new DataStorage();

    public static DataStorage getInstance() {
        return _instance;
    }

    private DataStorage() {
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public List<Dish> getAllDishes() {
        return allDishes;
    }

    public List<Table> getAllTables() {
        return allTables;
    }

    public Inventory getInventory() {
        if (inventory == null) {
            try {
                inventory = new Inventory();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inventory;
    }
}
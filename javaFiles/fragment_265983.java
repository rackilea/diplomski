public class MyClass<T extends MyClass> {

    private final Map<String, Manager> managerMap;

    @Inject // constructor injection
    @Named("ManagerMap")
    public class Myclass(Map<String, Manager> managerMap) {
        this.managerMap = managerMap;
    }

    @Override
    public void myFunc(@NotNull T myObj) {
        Manager manager = managerMap.get(myObj.getClass().getName());
        manager.call(myObj);
    }
}
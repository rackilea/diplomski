public enum HourEmployeePositionType implements HasIntId {

    None(0),
    Cleaner(1),
    Waiter(2),
    Barmen(3),
    Barback(4),
    HeadWaiter(5),
    Manager(6),
    Assistant_Manager(7),
    General_Manager(8);

    private final int id;

    HourEmployeePositionType(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public static HourEmployeePositionType getById(int id) {
         for (HourEmployeePositionType employeePositionType : HourEmployeePositionType.values()) {
             if (employeePositionType.getId == id) {
                 return employeePositionType;
             }
         }
         return HourEmployeePositionType.None;
    }
}
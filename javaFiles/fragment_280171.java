public enum CarType {

    HONDA(1, "Honda"), 
    TOYOTA(2, "Toyota"), 
    ALFA(3, "Alfa Romeo")
    // ...
    ;

    private int id = 0;
    private String displayName;

    public static CarType forId(int id) {
        for (CarType type : CarType.values()) {
            if (type.id == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("No car type with number " + id);
    }

    private CarType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getId() {
        return id;
    }

}
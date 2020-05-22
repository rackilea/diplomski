public enum MaintenanceType {
    INSTALLATION(1), REMOVAL(2);

    private int type;

    private MaintenanceType(int t) {
        type = t;
    }

    public int getType() {
        return type;
    }
}

public class Maintenance {

    private MaintenanceType type;

    private String serialNumber;
    private String partName;

    // getters and setters

    public boolean isInstallation(){
        return type == MaintenanceType.INSTALLATION;
    };
    public boolean isRemoval(){
        return type == MaintenanceType.REMOVAL;
    };
}
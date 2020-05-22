public abstract class VehicleChassis implements Chassis{
    public String chassisName;
    VehicleChassis() {
        chassisName = "name";
    }
    VehicleChassis(final String chassisName) {
        this.chassisName = chassisName;
    }
}
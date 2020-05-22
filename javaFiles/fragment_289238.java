public interface Machine {
    public void turnOn();
    public void turnOff();
}
final class MachineImpl {
    void turnOn() {/*logic here*/}
    void turnOff() {/*logic here*/}
}
public final class Heater implements Machine {
    private MachineImpl impl = new MachineImpl();
    @Override public void turnOn() { this.impl.turnOn(); }
    @Override public void turnOff() { this.impl.turnOff(); }
    // heater methods here
}
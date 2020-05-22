public class ApplicationContext {

    static ApplicationContext CTX;
    public static ApplicationContext get() {
        if( CTX == null ) {
            CTX = new ApplicationContext();
        }
        return CTX;
    }

    private Pin pin;
    public Pin getPin() { return pin; }
    public void setPin(Pin pin) { this.pin = pin; }

    // ... add more stuff here ...

    public void logout() {
        CTX = null;
    }
}
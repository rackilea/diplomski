public class ErrorEvent extends Event {
    private final int errorCode;

    protected ErrorEvent(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getError() {
        return errorCode;
    } 
}

public class WindowMalfunction extends ErrorEvent {
    public WindowMalfunction() { super(1); }
}

public class PowerOut extends ErrorEvent { 
    public PowerOut() { super(2); }
}
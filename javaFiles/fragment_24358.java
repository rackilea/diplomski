class LoginEvent extends EventObject {

    public static final int LOGIN_SUCCEEDED = 0;
    public static final int LOGIN_FAILED = 1;
    public static final int LOGIN_DIALOG_CLOSED = 2;

    private int id;

    public LoginEvent(Object source, int id) {
        super(source);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
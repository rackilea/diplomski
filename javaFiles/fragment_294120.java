class Login {
    private static final Login INSTANCE;
    private Login() {}
    public Login getInstance() {
        if (INSTANCE == null) { INSTANCE = new Login(); }
        return INSTANCE;
    }

    private String meno;
    // ...
}
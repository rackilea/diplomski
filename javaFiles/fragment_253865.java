public enum Settings {
    WelcomeMessage ("helloworld"),
    ByeMessage   ("yo");

    public final String value;

    Settings(String value) {
        this.value = value;
    }
}
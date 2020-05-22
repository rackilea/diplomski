package nl.tjit;
    public enum SingletonTest {
    INSTANCE;

    private final String whoami = "I am your father";

    public String getWhoami() {
        return whoami;
    }
}
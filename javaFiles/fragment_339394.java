public class MyDynaBundle extends ResourceBundle {

    @Override
    protected Object handleGetObject(String key) {
        // Implement bundle value retrieval by key.
    }

    @Override
    public Enumeration<String> getKeys() {
        // If necessary, implement retrieval of all valid keys.
    }

}
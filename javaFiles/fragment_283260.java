public class DBMessagesBundle extends ResourceBundle {
    @Override
    protected String handleGetObject(String key){
        ...
    }

    @Override
    public Enumeration<String> getKeys() {
        ...
    }
}
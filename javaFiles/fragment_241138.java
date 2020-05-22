public class PasswordHolder {

    private static PasswordHolder instance = null; 
    private final Map<String, Password> map = new HashMap<String, Password>();

    private PasswordHolder() {
        // nothing to do
    }

    public static PasswordHolder getInstance() {
        if (instance == null) {
            instance = new PasswordHolder();
        }
        return instance;
    }

    public void addPassword(String name, char[] pass) {
        if (map.containsKey(name)) {
            // throw some sort of Exception("Duplicate password name, man.")
        }
        map.put(name, new Password(pass));
    }

    public Password getPassword(String name) {
        return map.get(name);
    }

}
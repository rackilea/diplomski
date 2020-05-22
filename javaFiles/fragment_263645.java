public class YourClass {

    private static Locale currentLocale;
    private static ResourceBundle messages;

    static public void main(String[] args) {

        String language;
        String country;

        if (args.length != 2) {
            language = new String("en");
            country = new String("US");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);
        }

        currentLocale = new Locale(language, country);

        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static ResourceBundle getMessages() {
        return messages;
    }
}
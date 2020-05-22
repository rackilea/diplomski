public class MyUtils {

    private static final ResourceBundle bundle = ... ;

    public static FXMLLoader getLoader(URL location) {
        return new FXMLLoader(location, bundle);
    }

}
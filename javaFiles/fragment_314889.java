public class TokenUtils {

    private static final String TOKEN_PROPERTY = "token";

    public static Token findToken(JComponent component) {
        JRootPane root = component.getRootPane();
        if (root != null) {
            return Token.class.cast(root.getClientProperty(TOKEN_PROPERTY));
        }
       return null;
    }

    public static void putToken(JComponent component, Token token) {
        JRootPane root = component.getRootPane();
        if (root != null) {
            root.putClientProperty(TOKEN_PROPERTY, token);
        }
    }
}
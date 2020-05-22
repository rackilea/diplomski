public static final URLEncoder DEFAULT = new URLEncoder();
static {
    DEFAULT.addSafeCharacter('~');
    DEFAULT.addSafeCharacter('-');
    DEFAULT.addSafeCharacter('_');
    DEFAULT.addSafeCharacter('.');
    DEFAULT.addSafeCharacter('*');
    DEFAULT.addSafeCharacter('/');
}
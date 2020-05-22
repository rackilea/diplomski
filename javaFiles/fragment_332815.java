public static ResourceBundle R;

public static void main(String[] args) {
   Locale l = new Locale(args[0], args[1]); // should have a check here :-)
   R = ResourceBundle.getBundle("l10n/lang.properties", l); 
}
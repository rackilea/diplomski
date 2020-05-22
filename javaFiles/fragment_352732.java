public class MyResourceBundleExample {

    public static void main(String[] args) {
        Locale locale = new Locale("da", "DK");

        MyResourceBundle myResourceBundle = new MyResourceBundle();

        System.out.println(myResourceBundle.getText(locale, "PERSON_3"));
    }

}
public class Configuration {
    private static boolean convertToUppercase = true;

    public static void setConvertToUppercase(boolean convert) {
        convertToUppercase = convert;
    }

    public static boolean getConvertToUppercase() {
        return convertToUppercase;
    }
}
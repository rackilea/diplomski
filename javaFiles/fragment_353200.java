public class EnumFinder {

    public static <T extends Enum<T>>  boolean isInEnum(Class<T> clazz, String name) {
        for (T e : clazz.getEnumConstants()) {
            if (e.name().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] argv) {
        System.out.println(isInEnum(MYENUM.class, "one"));   // true
        System.out.println(isInEnum(MYENUM1.class, "one"));  // false
    }
}
// Doesn't get warning
public static String test(final boolean flag) {
    if (flag) {
        System.out.println("flag enabled");
        return "yes";
    }
    return "no";
}
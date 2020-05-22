public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(convert("09:07.110"));
            System.out.println(convert("9:07.110"));
            System.out.println(convert("09:7.1"));
            System.out.println(convert("9:07.11"));
            System.out.println(convert("9:7a.110"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String convert(String str) throws IllegalArgumentException {
        String mm = str.substring(0, str.indexOf(":"));
        String ss = str.substring(str.indexOf(":") + 1, str.indexOf("."));
        String mil = str.substring(str.indexOf(".") + 1);
        if (mm.length() == 0 || mm.length() > 2 || ss.length() == 0 || ss.length() > 2 || mil.length() == 0
                || mil.length() > 3 || !mm.matches("[0-9]+") || !ss.matches("[0-9]+") || !mil.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid time string");
        }
        mm = mm.length() == 1 ? "0" + mm : mm;
        ss = ss.length() == 1 ? "0" + ss : ss;
        mil = mil.length() == 1 ? "00" + mil : (mil.length() == 2 ? "0" + mil : mil);
        return mm + ":" + ss + "." + mil;
    }
}
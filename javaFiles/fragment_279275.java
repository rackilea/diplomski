public class EmployeeNames {

    public static String[] convertName(String[] names) {
        for (int i = 0; i < 10; i++) {
            names[i] = names[i].substring(names[i].length() - 2, names[i].length());
        }
        return names;
    }
}
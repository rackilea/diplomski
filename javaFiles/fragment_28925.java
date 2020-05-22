class EmployeeNames {
    public static String[] convertName(String[] lastNames) {
        String[] formattedNames = new String[lastNames.length];
        for (int i = 0; i < lastNames.length; i++) {
            formattedNames[i] = lastNames[i].substring(lastNames[i].length() - 1) + "."
                    + lastNames[i].substring(lastNames[i].length() - 2, lastNames[i].length() - 1) + "." + lastNames[i];

        }
        return formattedNames;
    }

}

public class EmployeeNamesTester {

    public static void main(String[] args) {
        String[] lastNames = { "Jones", "Roberts", "Lee", "Chang", "Patel", "Park", "Anderson", "Liu", "Smith",
                "Lopez" };
        String[] formattedNames = EmployeeNames.convertName(lastNames);
        for (String formattedName : formattedNames) {
            System.out.println(formattedName);
        }

    }

}
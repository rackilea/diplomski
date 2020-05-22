public class Main {


    public static void main(String[] args){
        String password = "1Aallll";
        String l3password = "1A ";
        String l2password = "aAaaaaa";
        String l1password = "1Aallll";

        System.out.println("isLongEnough " + isLongEnough(password));
        System.out.println("hasNoSpaces " + hasNoSpaces(password));
        System.out.println("atLeastOneUpper " + atLeastOneUpper(password));
        System.out.println("atLeastOneLower " + atLeastOneLower(password));
        System.out.println("atLeastOneDigit " + atLeastOneDigit(password));

        System.out.println("isLevel1 " + isLevel1(l3password));
        System.out.println("isLevel1 " + isLevel1(l2password));
        System.out.println("isLevel1 " + isLevel1(l1password));

        System.out.println("isLevel2 " + isLevel2(l3password));
        System.out.println("isLevel2 " + isLevel2(l2password));
        System.out.println("isLevel2 " + isLevel2(l1password));
    }

    public static boolean isLevel1(String pwd) {
        int howMany = 0;
        if (isLongEnough(pwd) && hasNoSpaces(pwd)) {
            if (atLeastOneUpper(pwd)) {
                howMany++;
            }
            if (atLeastOneLower(pwd)) {
                howMany++;
            }
            if (atLeastOneDigit(pwd)) {
                howMany++;
            }
            if (howMany >= 2) {
                return true;
            }
        }
        return false;

    }

    public static boolean isLevel2(String pwd) {
        if (isLongEnough(pwd) && hasNoSpaces(pwd) && atLeastOneUpper(pwd) && atLeastOneLower(pwd) && atLeastOneDigit(pwd)) {
            return true;
        }
        return false;
    }

    private static boolean isLongEnough(String pwd) {
        if (pwd.length() >= 6) {
            return true;
        }
        return false;
    }

    private static boolean hasNoSpaces(String pwd) {
        boolean flag = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (!pwd.contains(" ")) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean atLeastOneUpper(String pwd) {
        boolean flag = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isUpperCase(pwd.charAt(i))) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean atLeastOneLower(String pwd) {
        boolean flag = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isLowerCase(pwd.charAt(i))) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean atLeastOneDigit(String pwd) {
        boolean flag = false;
        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isDigit(pwd.charAt(i))) {
                flag = true;
            }
        }
        return flag;

    }
}
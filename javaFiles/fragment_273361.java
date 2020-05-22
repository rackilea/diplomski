public class Separater {

static String splitString(String str) {
    String result = "";
    int i=0;
    while (i < str.length()) {//Using while instead of for, to avoid skipping characters due to auto increment by the loop.

        if (Character.isDigit(str.charAt(i))) {
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                result += str.charAt(i);
                i++;
            }
            result += "     ";
        } else if (Character.isAlphabetic(str.charAt(i))) {
            while (i < str.length() && Character.isAlphabetic(str.charAt(i))) {
                result += str.charAt(i);
                i++;
            }
            result += "     ";
        } else {
            while (i < str.length() && !Character.isAlphabetic(str.charAt(i)) && !Character.isDigit(str.charAt(i))) {
                result += str.charAt(i);
                i++;
            }
            result += "     ";
        }
    }
    return result;
}

public static void main(String[] args) {
    System.out.println(splitString("تجاؤي#*(اىيلاؤت678345شسسصي*&&*^*!!محجذلب"));
}
}
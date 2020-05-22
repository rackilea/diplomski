public class CustomStringUtil {
    public static boolean secondIsAnagram(String sFirst, String sSecond) {
        if (sFirst.length() != sSecond.length()) {
            return false;
        }
        int[] asciiChars = new int[256];
        for (int i = sFirst.length() - 1; i >= 0; --i) {
            ++asciiChars[sFirst.charAt(i)];
        }
        for (int i = sFirst.length() - 1; i >= 0; --i) {
            char currChar = sSecond.charAt(i);
            if (asciiChars[currChar] == 0) {
                return false;
            }
            --asciiChars[currChar];
        }
        return true;
    }
}
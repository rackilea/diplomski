public class Temp {

    public static void main (String args[]) {
        String input = convertSting("2BXX09XX2BYYYY");
        input = replaceSize(input, "0A");

        System.out.println(input);
    }

    private static String replaceSize(String input, String newSizeVal) {
        int sizePosition = 4;
        return input.substring(0, sizePosition) + newSizeVal + input.substring(sizePosition + newSizeVal.length(), input.length());
    }

    public static String convertSting (String input) {
        String findString = "2B";

        int firstIndex = input.indexOf(findString) + findString.length();
        return input.substring(0, firstIndex) + input.substring(firstIndex, input.length()).replace(findString, "2B2B");
    }
}
public class Main {
    public static void main(String[] args) {
        String input = "<phone-residence></phone-residence><marital-status>1</marital-status><phone-on-request></phone-on-request>";
        StringBuilder output = new StringBuilder();
        boolean capitalizeNext = false;
        for (int i = 0; i < input.length(); i++) {
            char thisChar = input.charAt(i);
            if (thisChar == '-') {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                output.append(String.valueOf(thisChar).toUpperCase());
                capitalizeNext = false;
            } else {
                output.append(thisChar);
                capitalizeNext = false;
            }
        }
        System.out.println(output.toString());
    }
}
public class Main {
    public static void main(String[] args) {
        String input = "<phone-residence></phone-residence><marital-status>1</marital-status><phone-on-request></phone-on-request>";

        StringBuilder output = new StringBuilder();

        // This is used to determine if the next character should be capitalized
        boolean capitalizeNext = false;

        // Loop through each character of the input String
        for (int i = 0; i < input.length(); i++) {

            // Obtain the current character from the String
            char thisChar = input.charAt(i);

            if (thisChar == '-') {

                // If this character is a hyphen, set the capitalizeNext flag, but do NOT add this character to 
                // the output string (ignore it)
                capitalizeNext = true;

            } else if (capitalizeNext) {

                // The last character was a hyphen, so capitalize this character and add it to the output string
                output.append(String.valueOf(thisChar).toUpperCase());

                // Reset the boolean so we make a new determination on the next pass
                capitalizeNext = false;

            } else {

                // Just a regular character; add it to the output string as-is
                output.append(thisChar);

                // Reset the boolean so we make a new determination on the next pass
                capitalizeNext = false;

            }
        }

        // Just print the final output
        System.out.println(output.toString());
    }
}
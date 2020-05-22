public class MathRegex {
    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "45+√4+√5+sin(6)+6^3";
        String patternSqrt = "√(\\d+)";         // Pattern to find √digit(s)
        String patternSine = "sin\\((\\d+)\\)"; // Pattern to find sin(digit(s))
        String patternPow = "(\\d+)\\^(\\d+)";  // Pattern to capture digit(s)^digit(s)

        // Create a Pattern object
        Pattern sqrtPattern = Pattern.compile(patternSqrt);
        Pattern sinPattern = Pattern.compile(patternSine);
        Pattern powPattern = Pattern.compile(patternPow);

        // Now create matcher object for each operation.
        Matcher sqrtMatch = sqrtPattern.matcher(line);
        String stringSqrt = sqrtMatch.replaceAll("Math.sqrt($1)");

        Matcher sinMatch = sinPattern.matcher(stringSqrt); // notice feeding to updated string
        String stringSine = sinMatch.replaceAll("Math.sin($1)");

        Matcher powMatch = powPattern.matcher(stringSine);
        String output = powMatch.replaceAll("pow($1, $2)");

        System.out.println(output);

        // 45+Math.sqrt(4)+Math.sqrt(5)+Math.sin(6)+pow(6, 3)
    }
}
// Regex to match a "state zip" sequence, and capture each part in its own group
String regex = "(W[AY]|C[AO])\\s+(\\d{5})";

// Some sample input
String input = "blah blah WA 98121 blah blah CA 56679 blah blah";

Matcher matcher = Pattern.compile(regex).getMatcher(input);
while (matcher.find()) { // move to next match, if one exists
    String state = matcher.group(1);
    String zip = matcher.group(2);
    // Work with state and zip values
    System.out.println("State = " + state + ", zip = " + zip);
}
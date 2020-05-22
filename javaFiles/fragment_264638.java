// Using Regular Expressions to remove Characters
String removeLetters = "[A-z]";
String removeNumbers = "\\d";

// This is the master list.
ArrayList<String> masterArray = new ArrayList<String>();
masterArray.add("7CC55");
masterArray.add("1C");
masterArray.add("255D");
masterArray.add("0F");


// These are used to split the integer and string characters
ArrayList<Integer> splitInteger = new ArrayList<Integer>();
ArrayList<String> splitString = new ArrayList<String>();

for (String element : masterArray) {
   String removingLetterCharacters = element.replaceAll(removeLetters, "");
   String removingNumberCharacters = element.replaceAll(removeNumbers, "");
   splitInteger.add(Integer.parseInt(removingLetterCharacters));
   splitString.add(removingNumberCharacters);
}
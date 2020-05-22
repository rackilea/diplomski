Pattern p0 = Pattern.compile("(\\[|\\]|\\,| )"); // removes brackets, commas, and spaces
Pattern p1 = Pattern.compile("(.)\\1{1,}"); // Removes duplicate characters
Pattern p2 = Pattern.compile("\\?");

String removeArrayCharacters = p0.matcher(charOutput.toString()).replaceAll("");
String removeDuplicates = p1.matcher(removeArrayCharacters).replaceAll("$1");
return p2.matcher(removeDuplicates).replaceAll("");
String str = "215348-jobpoint";
System.out.println("Input: \"" + str + "\"");

// Replace chunks of digits with a single '0':
str = str.replaceAll("\\d+", "0");
System.out.println("After replacing digit chunks: \"" + str + "\"");

// Replace chunks of letters with a single 'A':
str = str.replaceAll("[A-Za-z]+", "A");
System.out.println("After replacing letter chunks: \"" + str + "\"");

// Replace chunks of non-digits and non-letters with a single '~':
str = str.replaceAll("[^A-Za-z\\d]+", "~");
System.out.println("After replacing non-digit/non-letter chunks: \"" + str + "\"");

// Since we transformed every chunk of subsequent characters of the same type to a single character,
// retrieving the length-1 will get our amount of type-changes
int amountOfTypeChunks = str.length();
int amountOfTypeChanges = amountOfTypeChunks -1;
System.out.println("Result (amount of chunks of different types): " + amountOfTypeChunks);
System.out.println("Result (amount of type changes): " + amountOfTypeChanges);
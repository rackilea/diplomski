String string = "hello";  // 4 unique characters
Set<Character> uniqueChars = new HashSet<>();  // create an empty set to put the unique chars into

// split into char[]
char[] chars = string.toCharArray();

Arrays.stream(chars).forEach(c -> {
    // the following code will be run once for every char in the array

    uniqueChars.add(c);
    // adding the same char twice does not insert it twice
});
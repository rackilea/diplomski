public static String reverse(String words) {
    String[] wordArr = words.split(" ", 2); // split into a maximum of 2 Strings

    if (wordArr.length > 1) { // If there is more than 1 word
        // return the first word (wordArr[0]),
        // behind the reverse of the rest of the String (wordArr[1])
        return reverse(wordArr[1]) + " " + wordArr[0];
    }

    return wordArr[0]; // else, just return the one word
}
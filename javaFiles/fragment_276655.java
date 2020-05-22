public static String fLeft(Scanner inp) {
    String content = "         ";
    int charCount = 0;
    // do until scanner has a word
    while (inp.hasNext()) {
        String word = inp.next(); // take the next word
        if (word.contains("</left>")) { // if word contains </left> this is going to be last word. contains is used to make sure we don't miss it if there are some chars before </left>
            int startIndexOfLastWord = 0;
            int endIndexOfLastWord = word.indexOf("</left>");
            String lastWord = word.substring(startIndexOfLastWord, endIndexOfLastWord); // remove the </left> from the last word if any
            charCount += lastWord.length();
            if (charCount <= 70) {
                // if the oldContent length is less than or equal to 70 just append the word
                content = content + word + " ";
            } else {
                // if the oldContent length is greater than 70 then append new line, margin and the word
                content = content + "\n" + "     " + word + " ";
            }
            break;
        } else {
            charCount += word.length();
            if (charCount <= 70) {
                // if the oldContent length is less than or equal to 70 just append the word
                content = content + word + " ";
            } else {
                // if the oldContent length is greater than 70 then append new line, margin and the word
                content = content + "\n" + "     " + word + " ";
            }
        }
        // reset charCount to 0 if it reaches 70.
        if (charCount >= 70) charCount = 0;
    }
    return content;
}
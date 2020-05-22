if (words.size() < 3) { .... } // handle edge case specified in question

// grab lengths of first & second word
int len1 = words.get(0).length();
int len2 = words.get(1).length();

// now iterate over remaining words
for (int i = 2; i < words.size; ++i) {
    String newWord = words.get(i);
    int newLen = newWord.length();
    if (newLen != len1 + len2) {
        // word at index [i] does not have "Fibonacci size"
        return false;
    } else {
        // everything good, we need to move the lengths
        len1 = len2;
        len2 = newLen;
    }
}
// all the words had "Fibonacci size"
return true;
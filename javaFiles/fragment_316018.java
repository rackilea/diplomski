String str = "blah\"blah\\blah\n";

int index = 0;
while (true) {
    // find the beginning
    while (index < str.length() && str.charAt(index) != '\"')
        index++;
    int beginIndex = index;
    if (index == str.length()) // no string found
        break;
    index++;
    // find the ending
    while (index < str.length()) {
        if (str.charAt(index) == '\\') {
            // escape, ignore the next character
            index += 2;
        } else if (str.charAt(index) == '\"') {
            // end of string found
            System.out.println(beginIndex + " " + index);
            break;
        } else {
            // plain content
            index++;
        }
    }
    if (index >= str.length())
        throw new IllegalArgumentException(
                "String literal is not properly closed by a double-quote");
    index++;
}
public static int countCharOfString(char quote, CharSequence sequence) {

    int total = 0, length = sequence.length();

    for(int i = 0; i < length; i++){
        char c = sequence.charAt(i);
        if (c == '"') {
            // Skip quoted sequence
            for (i++; i < length && sequence.charAt(i)!='"'; i++) {}
        } else if (c == quote) {
            total++;
        }
    }

    return total;
 }
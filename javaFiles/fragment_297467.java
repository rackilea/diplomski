private static boolean isVowel(String line) {
    line = (line != null) ? line.trim() : "";
    if (line.length() == 1) {
        switch (Character.toUpperCase(line.charAt(0))) {
        case 'A': case 'E': case 'I': case 'O': case 'U':
            return true;
        }
    }
    return false;
}
public static int findSubString(String input, String pattern) {
    int output = 0;
    for (int i = 0; i <= input.length() - pattern.length(); i++) {
        boolean ok = true;
        for (int k = 0; k < pattern.length(); k++) {
            if(input.charAt(i + k) != pattern.charAt(k)) {
                ok = false;
                break;
            }
        }
        if(ok) output++;
    }
    return output;
}
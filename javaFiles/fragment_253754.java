static String removeSpaces(String s) {
    // check preconditions for fast exit before creating new objects
    if (s == null || s.isEmpty()) {
        return "";
    }
    // use StringBuilder for pure local operations to avoid synchronization costs
    StringBuilder sb = new StringBuilder();
    for (int i=0;i<s.length();i++) {
        sb.append(s.charAt(i)); // the code is always the same for all characters
        // now skip runs of spaces
        if(s.charAt(i)==' ') {
            while(i<s.length()-1 && s.charAt(i+1) == ' ') {
                i++;
            }
        }
    }
    return sb.toString();
}
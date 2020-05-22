public boolean containsNoDigits(String s) {
    s = s.toLowerCase();
    char[] n = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == n[0] || c == n[1] || c == n[2] || c == n[3] || c == n[4] || 
                c == n[5] || c == n[6] || c == n[7] ||  c == n[8] || c == n[9]) {
            return false; // if s has no digit
        }
    }
    return true; // if s has digit
}
boolean containsRepeatingDigits(final int n) {
    final boolean digits[] = new boolean[10];
    for(char c : String.valueOf(n).toCharArray()) {
        final int i = c-'0';
        if(digits[i])
            return true;
        digits[i] = true;
    }
    return false;
}
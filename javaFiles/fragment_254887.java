for (int i = 0; i < n.length(); i++){
    char c = n.charAt(i);
    if (c >= '0' && c <= '9') {
        counts[c - '0']++;
    }
}
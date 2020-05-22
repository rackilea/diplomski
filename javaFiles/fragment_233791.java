private static int countHoles(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
        if ("ADOPQR".indexOf(c) != -1) {
            count++;
        } else if (c == 'B') {
            count += 2;
        }
    }
    return count;
}

// or:

private static int countHoles(String s) {
    return s.chars().map(c -> c == 'B' ? 2 : "ADOPQR".indexOf(c) != -1 : 1 : 0).sum();
}
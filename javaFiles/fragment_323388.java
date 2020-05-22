for (String b : userinput.split(" ")) {
    if (isAlpha(b)) {
        if (largestWord.length() == 0) {
            largestLength = b.length();
            largestWord = b;
        } else if (b.length() >= largestLength) {
            largestLength = b.length();
            largestWord = b;
        }
    }
}
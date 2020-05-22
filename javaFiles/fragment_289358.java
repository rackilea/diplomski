for (int i = 0; i < string.length() - word.length() + 1; i++) { // Add  '+ 1'
    String substring = string.substring(i, i + word.length());
    // System.out.println(substring);
    if (match(substring, word)) {
        count++;
    }
}
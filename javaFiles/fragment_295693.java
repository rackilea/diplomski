for(int n = 0 ; n < scannedString.length() ; /* yes, empty! */ ) {
    // Ignore non-digit characters
    if (!Character.isDigit(scannedString.charAt(n))) {
        n++;
        continue;
    }
    // char at position n is a digit; try the next one,
    // then the next, until the string ends or you find a non-digit:
    int len = 1;
    while (n+len < scannedString.length() && Character.isDigit(scannedString.charAt(n+len))) {
        len++;
    }
    // At this point len is the length of the next number string.
    // Take the substring, and parse it:
    int num = Integer.parseInt(scannedString.substring(n, n+len));
    // Advance sum and prod. Note that there is no redundant assignment.
    sum += num;
    prod *= num;
    // Advance the loop index inside the body
    n += len;
}
public static boolean isPasswordValid(String password) {
    // 1 to 3 occurrences of lowercased chars
    if (!password.matches("(?:[^a-z]*[a-z]){1,3}[^a-z]*")) {
        return false;
    }
    // 2 to 4 occurrences of uppercased chars
    if (!password.matches("(?:[^A-Z]*[A-Z]){2,4}[^A-Z]*")) {
        return false;
    }
    // 3 to 5 occurrences of digits
    if (!password.matches("(?:[^0-9]*[0-9]){3,5}[^0-9]*")) {
        return false;
    }
    // 4 to 6 occurrences of special chars (simplified to "_", "." or "-")
    if (!password.matches("(?:[^_.-]*[_.-]){4,6}[^_.-]*")) {
        return false;
    }
    // no other kind of chars, and password length from 3 to 20
    if (!password.matches("[a-zA-Z0-9_.-]{3,20}")) {
        return false;
    }
    return true;
}
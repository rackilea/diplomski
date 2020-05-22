public static boolean isValidSSN(String ssn) {
    double number = Double.parseDouble(ssn);

    if (number >= 100000000 && number <= 999999999) {
        return true;
    }
    else {
        return false;
    }
}
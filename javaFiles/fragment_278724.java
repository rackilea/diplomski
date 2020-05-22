public int strDist(String str, String sub) {

    if (str.length() < sub.length())
        return 0;
    // simplified condition
    if (str.equals(sub))
        return str.length();

    if (str.length() < 2) {
        if (str.contains(sub)) {
            // corrected (if str and sub are both empty strings, you don’t want to return 1)
            return str.length();
        }
        return 0;
    }

    // deleted str.length() == 2 case that didn’t work correctly

    if (str.startsWith(sub) && str.endsWith(sub)) {
        return str.length();
    }
    if (str.startsWith(sub)) { // simplified
        // subtracting only 1 and added return statement
        return strDist(str.substring(0, str.length() - 1), sub);
    }
    // changed completely -- didn’t understand; added return statement, I believe this solved your test case
    if (str.endsWith(sub))
        return strDist(str.substring(1), sub);
    return strDist(str.substring(1, str.length() - 1), sub);

}
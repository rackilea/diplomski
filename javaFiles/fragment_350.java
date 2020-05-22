// for a non-null password, return a String of the same length with all
//   of the characters set to an 'X'
public static String getObfuscatedPassword(String pw)
{
    Objects.requireNonNull(pw, "Null pw input");
    return pw.replaceAll(".", "X");
}

// for a non-null ssn, return a String where every digit is replaced
//   by an 'X'; other characters (such as a -) are unchanged
public static String getObfuscatedSSN(String ssn)
{
    Objects.requireNonNull(ssn, "Null ssn input");

    return ssn.replaceAll("[0-9]", "X");
}

// return true if the specified ssn is not null and
//   matches the format of ###-##-###
public static boolean isValidSSN(String ssn)
{
    // ensures there is something for us to validate
    //   NOTE: technically the .isEmpty is not needed
    if (ssn == null || ssn.isEmpty()) {
        return false;
    }

    // ensure in the format of ###-##-###
    return Pattern.matches("[\\d]{3}-[\\d]{2}-[\\d]{3}", ssn);
}

// returns true if the username has at least one character, and
//  no digits; does not prevent having spaces in the name (could
//  be added); uses a for loop rather than regular expressions for
//  a fun difference in approach
public static boolean isValidUsername(String name)
{
    boolean charFound = false;
    boolean digitFound = false;
    if (name == null || name.isEmpty()) {
        return false;
    }

    for (int i = 0; i < name.length(); ++i) {
        // check if the current name[i] is a letter or digit
        //  the OR will keep a true once it is set
        charFound = charFound || Character.isLetter(name.charAt(i));
        digitFound = digitFound || Character.isDigit(name.charAt(i));
    }

    return charFound && ! digitFound;
}
public static boolean magicFunctionImplementation(String permission, String permissionExpression) {
    boolean res = false;
    String rx = permissionExpression.replace(".", "\\.") // escape the dot in regex
            .replace("*", ".*") // prep the * token to match any 0+ chars
            .replace("?", ".")  // . will match any 1 char
            .replaceAll("\\[([^\\]\\[]*)]", "($1)") // [a,b] => (a|b) = match a or b
            .replaceAll("<([^<>]+)>", "(?:(?!$1)[^.])*") // <a,b> => (?:(?!a|b).)* = match text that is not a starting point of a or b
            .replace(",", "|"); // replace all commas with alternation symbol (for the above 2 patterns)
    if (permissionExpression.contains(permission)) { // if permissionExpr contains permission, it is TRUE
        res = true;
    } else {
        res = permission.matches(rx); // Check if the entire permission matches the regex
    }
    return res;
}
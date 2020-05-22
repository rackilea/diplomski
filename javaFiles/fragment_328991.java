public static boolean isTrans(String s, String t) {
    System.out.println(s + " - " + t);
    boolean isT = false;

    if (t.length() > 1) {

        if (s.charAt(0) == t.charAt(0) && (t.charAt(0) != t.charAt(1))) {
            return isTrans(s.substring(1, s.length()), t.substring(1, t.length()));
        }
        if (s.charAt(0) == t.charAt(0) && t.charAt(0) == t.charAt(1)) {
            return isTrans(s, t.substring(1, t.length()));
        }
    } else {
        isT = (s.charAt(0) == t.charAt(0)) ? true : false;
    }

    return isT;
}
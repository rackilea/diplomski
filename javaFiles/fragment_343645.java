String str = "[this] is...";
String search = "[this] is";

Pattern p = Pattern.compile("(?!<\\p{IsAlphabetic})"
        + Pattern.quote(search) + "(?!\\p{IsAlphabetic})");
boolean matches = p.matcher(str).find();
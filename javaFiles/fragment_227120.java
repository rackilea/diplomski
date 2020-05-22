public static String addSlashesSearchMode(String s) {
    return addSlashes(s, true);
}

public static String addSlashes(String s) {
    return addSlashes(s, false);
}

private static String addSlashes(String s, boolean search) {
    if (s == null) {
        return s;
    }
    String[][] chars;
    if(!search) {
        chars = new String[][ ]{
                {"\\",  "\\\\"},
                {"\0", "\\0"},
                {"'", "\\'"}, 
                {"\"",  "\\\""},
                {"\b",  "\\b"},
                {"\n",  "\\n"},
                {"\r",  "\\r"},
                {"\t",  "\\t"},
                {"\\Z", "\\\\Z"}, // not sure about this one
                {"%", "\\%"},     // used in searching
                {"_", "\\_"}
        };
    } else {
        chars = new String[][ ]{
                {"\\",  "\\\\"},
                {"\0", "\\0"},
                {"'", "\\'"}, 
                {"\"",  "\\\""},
                {"\b",  "\\b"},
                {"\n",  "\\n"},
                {"\r",  "\\r"},
                {"\t",  "\\t"},
                {"\\Z", "\\\\Z"}, // not sure about this one
        };
    }
    for (String[] c : chars) {
        s = s.replace(c[0], c[1]);
    }
    return s;
}
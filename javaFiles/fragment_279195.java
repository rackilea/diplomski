Pattern regex = Pattern.compile(
    "(\\S+)       # one or more non-whitespace characters -> group 1\n" +
    "\\s+         # one or more whitespace characters\n" +
    "(\\S+)       # one or more non-whitespace characters -> group 2\n" +
    "\\s+         # one or more whitespace characters\n" +
    "\\[          # [\n" +
    "([^\\[\\]]*) # anything except [] -> group 3\n" +
    "\\]          # ]\n" +
    "\\s*/        # optional whitespace, then /\n" +
    "([^/]*)      # anything except / -> group 4\n" +
    "/            # /\n" +
    "([^/]*)      # anything except / -> group 5", 
    Pattern.COMMENTS);
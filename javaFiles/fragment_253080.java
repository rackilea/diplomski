final Pattern ptr = Pattern.compile(
    "\\b([A-Z0-9\\._%+-]+)"+
    "(?:@|\\s*\\[\\s*at\\s*\\]\\s*)"+
    "([A-Z0-9\\.-]+)"+
    "(?:\\.|\\s*\\[\\s*dot\\s*\\]\\s*)"+
    "([a-z]{2,6})\\b", Pattern.CASE_INSENSITIVE);
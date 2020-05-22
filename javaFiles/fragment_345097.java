Pattern regex = Pattern.compile(
    "^       # Anchor the match at the start of the string\n" +
    "(?:     # Match either...\n" +
    " &      # the wildcard character\n" +
    " |      # or a number between 0 and 255\n" +
    " (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\n" +
    " \\.    # followed by a dot, followed by...\n" +
    " (?:    # ...either...\n" +
    "  &     # the wildcard character\n" +
    "  |     # or a number etc. etc.\n" +
    "  (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\n" +
    "  \\.\n" +
    "  (?:\n" +
    "   &\n" +
    "   |\n" +
    "   (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\n" +
    "   \\.\n" +
    "   (?:\n" +
    "    &\n" +
    "    |\n" +
    "    (?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\n" +
    "   )\n" +
    "  )\n" +
    " )\n" +
    ")\n" +
    "$        # Anchor the match at the end of the string", 
    Pattern.COMMENTS);
try {
    if (subjectString.matches(
        "(?ix)\\A(?:                                                  # Anchor address\n" +
        " (?:  # Mixed\n" +
        "  (?:[A-F0-9]{1,4}:){6}                                # Non-compressed\n" +
        " |(?=(?:[A-F0-9]{0,4}:){2,6}                           # Compressed with 2 to 6 colons\n" +
        "     (?:[0-9]{1,3}\\.){3}[0-9]{1,3}                     #    and 4 bytes\n" +
        "     \\z)                                               #    and anchored\n" +
        "  (([0-9A-F]{1,4}:){1,5}|:)((:[0-9A-F]{1,4}){1,5}:|:)  #    and at most 1 double colon\n" +
        " |::(?:[A-F0-9]{1,4}:){5}                              # Compressed with 7 colons and 5 numbers\n" +
        " )\n" +
        " (?:(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}  # 255.255.255.\n" +
        " (?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])           # 255\n" +
        "|     # Standard\n" +
        " (?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}                    # Standard\n" +
        "|     # Compressed\n" +
        " (?=(?:[A-F0-9]{0,4}:){0,7}[A-F0-9]{0,4}               # Compressed with at most 7 colons\n" +
        "    \\z)                                                #    and anchored\n" +
        " (([0-9A-F]{1,4}:){1,7}|:)((:[0-9A-F]{1,4}){1,7}|:)    #    and at most 1 double colon\n" +
        "|(?:[A-F0-9]{1,4}:){7}:|:(:[A-F0-9]{1,4}){7}           # Compressed with 8 colons\n" +
        ")/[A-F0-9]{0,4}\\z                                                    # Anchor address")) 
        {
        // String matched entirely
    } else {
        // Match attempt failed
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}
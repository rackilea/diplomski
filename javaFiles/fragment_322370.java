try {
    String subjectString = "www.google.comwww.yahoo.comwww.ebay.com";
    String[] splitArray = subjectString.split("(?i)(www\\.((?!www\\.).)*)");
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}
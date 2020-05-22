PatternBuilder patternBuilder = new PatternBuilder()
        .addDefinition('X', ".")
        .addDefinition('Y', "Y")
        .addDefinition('M', "[0-9]")
        .addDefinition('N', "\\d")
        .addDefinition('A', "[a-zA-Z]");
String rePattern = patternBuilder.buildRegexPattern("XxxYMXXXXXA"); // case insensitive, x == X
System.out.println("Pattern: '" + rePattern + "'");
Pattern p = Pattern.compile(rePattern);

String[] tests = new String[]{
    "39JY412345O", // Original, match
    "39JY41234FO", // replaced 5 with F, still matching
    "39JY4123457", // replaced O with 7, no match
    "A9JY4123457"  // replaced 3 with A, no match
};        
for (String s : tests) {
    Matcher m = p.matcher(s);
    System.out.println("Test '" + s + "': " + m.matches());
}
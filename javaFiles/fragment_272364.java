import java.util.regex.*;
try {
    Pattern regex = Pattern.compile("(\\d\\{1-3\\})\\.(\\d\\{1-3\\})\\.(\\d\\{1-3\\})\\.(\\d\\{1-3\\})");
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        for (int i = 1; i <= regexMatcher.groupCount(); i++) {
            // matched text: regexMatcher.group(i)
            // match start: regexMatcher.start(i)
            // match end: regexMatcher.end(i)
        }
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}
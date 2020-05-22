CharSequence inputStr = "abbabcd";

String patternStr = "(a(b*))+(c*)";

// Compile and use regular expression
Pattern pattern = Pattern.compile(patternStr);
Matcher matcher = pattern.matcher(inputStr);
boolean matchFound = matcher.find();

if (matchFound)
{
    // Get all groups for this match
    for (int i=0; i<=matcher.groupCount(); i++) 
    {
        String groupStr = matcher.group(i);
    }
}
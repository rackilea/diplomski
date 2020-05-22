Pattern thePattern = Pattern.compile(theRegexString);
Matcher m = thePattern.matcher(theStringToTest);
if (m.matches()) {
    return true;
}
return m.hitEnd();
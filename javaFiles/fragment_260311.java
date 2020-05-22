final String regex = "(?ms)(.+?(?=^\\d{2}\\s[A-Za-z]{3}\\s\\d{4}|\\z))";
final Pattern pattern = Pattern.compile( regex );
final Matcher matcher = pattern.matcher( input );

while (matcher.find()) {
    System.out.println("Match: " + matcher.group(0));
}
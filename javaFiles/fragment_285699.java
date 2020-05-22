String content = "..."; //Replace "..." with your content.
String patternString = "..."; //Replace "..." with your pattern.
String lastPatternSuccess = "None. You suck at Regex!";
for (int i = 0; i <= patternString.length(); i++) {
  try {
    String patternSubstring = patternString.substring(0, i);
    Pattern pattern = Pattern.compile(patternSubstring);
    Matcher matcher = pattern.matcher(content);
    if (matcher.find()) {
      lastPatternSuccess = i + " - Pattern: " + patternSubstring + " - Match: \n" + matcher.group();
    }
  } catch (Exception ex) {
    //Ignore and jump to next
  }
}
System.out.println(lastPatternSuccess);
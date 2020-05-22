String regex = "(?:[^\\t]*)\\t(?:[^\\t]*)\\t([^\\t]*)\\t(?:[^\\t]*)";
Pattern pattern = Pattern.compile(regex);

Matcher matcher = pattern.matcher(input);
if (matcher.matches()) {
  System.err.println(matcher.group(1));
}
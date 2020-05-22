List<String> matchList = new ArrayList<String>();

Pattern regex = Pattern.compile("\\{([^}]*)\\}");
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) 
{
  matchList.add(regexMatcher.group());
}
List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile("-?(?:\\d+(?:\\.\\d+)?|\\.\\d+)");
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}
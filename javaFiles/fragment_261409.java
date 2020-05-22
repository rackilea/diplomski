String patternStr = "([^ .]+ +)*\\S*\\.\\S+";
String input = "file1.txt .project file2.jpg tricky file name.txt other tricky filenames containing áéíoéáóó.gif";
Pattern pattern = Pattern.compile(patternStr, Pattern.MULTILINE);
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {            
    System.out.println(matcher.group());
}
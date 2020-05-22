String line = "This is o n e l e tt e r $ % ! sentence";

Pattern pattern = Pattern.compile("\\w{2,}");
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println(matcher.group());
}
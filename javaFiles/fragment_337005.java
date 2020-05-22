Pattern pattern = Pattern.compile("\"((\\\\.|[^\"])+)\"");
Matcher matcher = pattern.matcher(line);

while (matcher.find()) {
  System.out.println(" FOUND "+matcher.groupCount()+" groups");
  System.out.println(matcher.group(1));
}
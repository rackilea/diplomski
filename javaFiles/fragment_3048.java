Pattern pattern = Pattern.compile("[0-9]+|(\\+|-|\\*)");
Matcher matcher = pattern.matcher("4+3 -2 + 1* 5 -2");
List<String> parts = new ArrayList<>();
while (matcher.find()) {
    parts.add(matcher.group());
}
String[] array = parts.toArray(new String[parts.size()]);
System.out.println(Arrays.toString(array));
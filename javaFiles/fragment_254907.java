String s = "BRTR val !http://www.w3.org/2001/XMLSchema# 78928458695 integer integer 33 integer";
Pattern pattern = Pattern.compile("([0-9]+\\s|\\s)integer");
Matcher matcher = pattern.matcher(s);
List<String> list = new ArrayList<>();
while (matcher.find()) {
    list.add('"' + matcher.group() + '"');
}
System.out.println(list); // ["78928458695 integer", " integer", "33 integer"]
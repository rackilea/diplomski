String detail = "UserDetail: Name=TestName1, Address=India, Name=TestName2, Address=USA";
List<String> result = new ArrayList<>();
Pattern pat = Pattern.compile("Name=(\\w+)");
Matcher matcher = pat.matcher(detail);
while (matcher.find())
    result.add(matcher.group(1));
System.out.println(result);
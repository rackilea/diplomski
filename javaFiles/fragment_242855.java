String str = "abc hello\" I am batman\"xoxo bat man";
Matcher m = Pattern.compile("(?:\"[^\"]*\"|\\S)+").matcher(str);
List<String> res = new ArrayList<>();
while (m.find())
    res.add(m.group().replaceAll("\"", ""));

System.out.println(res);       //[abc, hello I am batmanxoxo, bat, man]
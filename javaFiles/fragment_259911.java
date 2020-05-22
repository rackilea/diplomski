String s = "Hi, <@W12313>, <@U333111>!";
Pattern pattern = Pattern.compile("<@([WU][^>]*)>");
Matcher matcher = pattern.matcher(s);
List<String> res = new ArrayList<>();
while (matcher.find()){
    res.add(matcher.group(1)); 
} 
System.out.println(res);
// => [W12313, U333111]
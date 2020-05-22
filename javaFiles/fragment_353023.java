String s = "A B C D E";
Pattern p = Pattern.compile("(\\w\\s\\w)|\\w");
Matcher m = p.matcher(s);
List<String> res = new ArrayList<>();
while(m.find()){
        res.add(m.group());
}
System.out.println(res);          //    [A B, C D, E]
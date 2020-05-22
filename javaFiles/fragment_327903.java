String myString = "A=myPage{a1,b1,c1};B=myPage{a2,b2,c2};C=myPage{a3,b3,c3};";
List<String> list = new ArrayList<String>();
Matcher m = Pattern.compile("\\{([^{}]*)\\}").matcher(myString);
while(m.find())
{
    list.add(m.group(1));
}
System.out.println(list);
String x = "Hey my name is $name$; I have $years$ years old," + 
           "and I love play $sport$ and I live in $country$ !";
Pattern p = Pattern.compile("\\$\\w+\\$");
Matcher m = p.matcher(x);
Map<String, Integer> map = new LinkedHashMap<>();

while(m.find()) {
  String in = m.group().substring(1,m.group().length()-1);
  map.put(in, in.length());
}
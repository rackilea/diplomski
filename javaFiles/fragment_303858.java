String s = "√(A&B)=|C|";
Matcher m = Pattern.compile("("
  +  "(√\\()"
  + "|(\\))"
  + "|(\\w(\\&\\w)*)"
  + "|(=)"
  + "|(\\|)"
  + ")").matcher(s);

ArrayList<String> r = new ArrayList<>();
while(m.find())
  r.add(m.group(1));

System.out.printf("%s", r.toString());
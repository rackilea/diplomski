String s = "(1,0,quote),(1,0,place),(1,0,hall),(2,0,wall)";
Pattern p = Pattern.compile("\\d+,\\d+,[^)]+");
Matcher m = p.matcher(s);

List<String> l=new ArrayList<>();
while(m.find()) {
    l.add(m.group());
}

System.out.println(l);
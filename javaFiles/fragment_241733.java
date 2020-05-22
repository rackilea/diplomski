String a = "1 + 2 = 3 += 4 +--5";
Matcher m = Pattern.compile("\\d+|[^\\w\\s]+").matcher(a);
ArrayList<String> list = new ArrayList<String>();
while (m.find()) {
    list.add(m.group());
}
System.out.println(list);
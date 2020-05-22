String s = "thisIsTheEnd15";
Matcher m = Pattern.compile("[a-zA-Z][a-z]*|[0-9]+").matcher(s);
List<String> res = new ArrayList<>();
while (m.find()) {
    res.add(m.group(0));
}
System.out.println(res);
// => [this, Is, The, End, 15]
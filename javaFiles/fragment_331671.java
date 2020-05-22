String s = "Id 878-234 provide info for 1233444 no";
Pattern p = Pattern.compile("^Id\\s*([0-9]{3}-[0-9]{3})");
Matcher m = p.matcher(s);
while (m.find()) {
System.out.println(m.group(1));
} //=> 878-234
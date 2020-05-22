String data = "id: 1 name: Joe age:27 id: 2 name: Mary age:22";
Pattern namePtrn = Pattern.compile("age:(\\w+)");
Matcher nameMtchr = namePtrn.matcher(data);

while (nameMtchr.find()) {
   String find = nameMtchr.group(1);
   System.out.println("\t" + find);
}
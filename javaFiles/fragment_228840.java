String str = "This `99 is my small \"yy\"  xx`example_and_more ";
Pattern ptrn = Pattern.compile("(?U)(?>[^\\W\\d]\\p{M}*+)+|\\d+|[^\\w\\s]");
List<String> res = new ArrayList<>();
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    res.add(matcher.group());
}
System.out.println(res);
// => [This, `, 99, is, my, small, ", yy, ", xx, `, example_and_more]
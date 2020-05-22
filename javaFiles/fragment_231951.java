String s = "\"Test Line wo line break\"; \"Test Line \nwith line break\"\n\"Test Line2 wo line break\"; \"Test Line2 \nwith line break\"";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("\"[^\"]*\"").matcher(s);
while (m.find()) {
    m.appendReplacement(result, m.group().replaceAll("\\R+", ""));
}
m.appendTail(result);
System.out.println(result.toString());
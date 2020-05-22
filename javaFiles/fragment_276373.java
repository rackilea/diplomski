Pattern p = Pattern.compile("(\\w*\\s?){5}");
String s = "On the Insert tab the galleries include items that are designed to coordinate with the overall look of your document.";
Matcher m = p.matcher(s);
while (m.find()) {
   String words_group = m.group();
   System.out.println(words_group);
}
String text = "Hi How areYouToday";
Matcher m = Pattern.compile("(?<=[a-z])[A-Z]").matcher(text);

StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, "_"+m.group().toLowerCase());
}
m.appendTail(sb);

System.out.println(sb.toString()); //Hi How are_you_today
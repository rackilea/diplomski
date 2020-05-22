Pattern pattern = Pattern.compile("\\$@([^\\$@]+|$)");
CharSequence tag = "any tag$@ws2-role$@ws1-role";
Matcher matcher = pattern.matcher(tag);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
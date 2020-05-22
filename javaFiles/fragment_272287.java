String content ="(content1)'first' is the first to find then
    (content2)'second' and so on";
Matcher m = Pattern.compile("(?<=\\(content2\\))'(.*?)'").matcher(content);
while (m.find()) {
    System.out.println(m.group(1));
}
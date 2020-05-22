String input = "[[Animal rights]] [[Anthropocentrism]] [[Anthropology]]";
Matcher m = Pattern.compile("\\[\\[(.*?)\\]\\]").matcher(input);

while (m.find()) {
    System.out.println(m.group(1));
}
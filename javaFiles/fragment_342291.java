String text = "Hello World: [[DATA.[field]]] something else";

Pattern regex = Pattern.compile("(?<=\\[\\[).*?(?=\\]\\](\\s|$))", Pattern.MULTILINE);
Matcher regexMatcher = regex.matcher(text);

if (regexMatcher.find()) {
    System.out.println(regexMatcher.group());
}
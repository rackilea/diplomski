// regex for any sequence of non-comma, non-parenthesis characters that
// neither starts nor ends with whitespace:
Pattern p = Pattern.compile("[^,\\s()](?:[^,()]*[^,\\s()])?");
Matcher m = p.matcher(textToMatch);
while (m.find()) {
    System.out.println(m.group()); // print entire matched substring
}
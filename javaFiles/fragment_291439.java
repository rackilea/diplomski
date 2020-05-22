String foo = "Bug 1234 - description";
Pattern pattern = Pattern.compile("Bug\\s?(\\d*)", Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(foo);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}
String str = "This is 1 test 123-456-7890";

Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
Matcher matcher = pattern.matcher(str);
if (matcher.find()) {
    System.out.println(matcher.group(0));
}
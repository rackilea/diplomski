String str = "abc_resend.zip";
Pattern pattern = Pattern.compile("_(\\w+)\\.");
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}
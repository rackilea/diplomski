String str = "/service1/api/v1.0/foo/{fooId}/boo";

Pattern pattern = Pattern.compile("\\/.*?\\/api\\/v\\d+\\.\\d+\\/(.+)");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
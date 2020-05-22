String data = "['first data','second data', 'third data']";
Pattern pattern = Pattern.compile("'(.*?)'");

Matcher matcher = pattern.matcher(data);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}
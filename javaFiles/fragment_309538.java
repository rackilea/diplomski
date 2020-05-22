String text = "[\"222.222.222.222\", \"21.21.21.21\"]";

Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
Matcher matcher = pattern.matcher(text);

List<String> result = new ArrayList<>();

while (matcher.find()) {
    result.add(matcher.group());
}
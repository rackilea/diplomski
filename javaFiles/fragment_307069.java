Matcher matcher = Pattern.compile(regex).matcher(input);

List<String> result = new ArrayList<>();
while (matcher.find()) {
    result.add(matcher.group());
}
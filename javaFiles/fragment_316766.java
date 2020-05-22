String email = "john.doe@example.en.com";
Pattern pattern = Pattern.compile("(.)(.*?)(.@.)(.*?)(\\.[^\\.]+)$");
Matcher matcher = pattern.matcher(email);
if (matcher.find()) {
    email = matcher.group(1) + matcher.group(2).replaceAll(".", "*") +
            matcher.group(3) + matcher.group(4).replaceAll(".", "*") +
            matcher.group(5);
}
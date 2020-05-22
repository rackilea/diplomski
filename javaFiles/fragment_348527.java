Pattern pattern = Pattern.compile("^\\/w\\s+(?<username>\\w+)\\s+(?<message>.+)$");
Matcher matcher = pattern.matcher("/w username message");

if(matcher.matches()) {
    String username = matcher.group("username");
    String message = matcher.group("message");
}
Pattern pattern = Pattern.compile(regexPattern);
for(String value : values) {
    Matcher matcher = pattern.matcher(value);
    if (matcher.matches()) {
        // your code here
    }
}
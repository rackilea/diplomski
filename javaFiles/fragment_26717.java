Pattern all = Pattern.compile(
    "(?<lower>LOWERCASE.*)|(?<upper>UPPERCASE.*)|(?<reverse>REVERSE.*)|..."
);
Matcher m = all.matcher(inputStr);
if (m.find()) {
    String upper = m.group("upper");
    String lower = m.group("lower");
    String reverse = m.group("reverse");
    if (upper != null) {
        ... // Do something
    }
    if (lower != null) {
        ... // Do something
    }
    if (reverse != null) {
        ... // Do something
    }
}
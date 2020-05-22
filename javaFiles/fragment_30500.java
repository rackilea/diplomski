String regex = "\\d+(?:[.,]\\d+)?";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher("0 0.123 1.43 4 hello");

while (matcher.find()) {
    String number = matcher.group();
    // number can be integer or float
}
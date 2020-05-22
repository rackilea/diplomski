String delimStr = String(delim);
String regex;
if (delimStr.equals("^") {
    regex = "\\^"
} else if (delimStr.charAt(0) == '^') {
    // This assumes that all characters are distinct.
    // You may need a stricter check to make this work in general case.
    regex = "[" + delimStr.charAt(1) + delimStr + "]";
} else {
    regex = "[" + delimStr + "]";
}
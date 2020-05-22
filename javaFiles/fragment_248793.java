String before = ", Size ";
String after = ", User";

for (Element element : elements) {
    String text = element.text();
    String size = text.substring(text.indexOf(before) + before.length(), text.indexOf(after));
    // ...
}
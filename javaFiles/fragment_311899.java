int hyphenIndex = text.indexOf("-");
if (hyphenIndex > -1) {
    String author = text.substring(0, hyphenIndex);
    System.out.println(author);
}
String title = text.substring(hyphenIndex + 1, text.length());
System.out.println(title);
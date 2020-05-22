String[] crap = {"(", ")", ",", ";"};
String text = "(123, 234; 345, 456) (567, 788; 899, 900)";
for (String replace : crap) {
    text = text.replace(replace, " ").trim();
}
// This replaces any multiple spaces with a single space
while (text.contains("  ")) {
    text = text.replace("  ", " ");
}
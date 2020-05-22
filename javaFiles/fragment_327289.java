List<String> words = new ArrayList<>();
String line = "    W metal, w liczbę, w trupie ciało, -";
Matcher m = Pattern.compile("\\p{L}+").matcher(line);
while (m.find()) {
    words.add(m.group());
}
System.out.println(words); // => [W, metal, w, liczbę, w, trupie, ciało]
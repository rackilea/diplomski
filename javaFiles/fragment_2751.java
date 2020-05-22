StringBuilder regex = new StringBuilder("\\b(");
for (String word : stringList) {
    regex.append(Pattern.quote(word));
    regex.append("|");
}
regex.setLength(regex.length() - 1); // delete last added "|"
regex.append(")\\b");
Pattern pattern = Pattern.compile(regex.toString());
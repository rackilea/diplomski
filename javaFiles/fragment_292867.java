String rx = "\\d+(?:,\\d+)?\\s*m\\u00B2";
Pattern p = Pattern.compile(rx);
Matcher matcher = p.matcher("E.g. : 4668,68 m² some text, some text 48 m²  etc");
if (matcher.find()){
    System.out.println(matcher.group());
}
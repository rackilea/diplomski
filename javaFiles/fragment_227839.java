String s = "[[Category:sometext]]\n[[Category:sometext|*]]\n[[Category:sometext|]]\n[[Category:sometext*]]"; 
String rx = "\\[\\[Category:(.*?)\\|?\\*?\\]\\]";
Pattern p = Pattern.compile(rx);
Matcher matcher = p.matcher(s);
while (matcher.find())
    System.out.println(matcher.group(1));
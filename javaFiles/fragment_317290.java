String word1 = "is";
String word2 = "a";
String text = "This is a sample";

String regex =
    "(\\s|^)" + 
    Pattern.quote(word1) +
    "\\s+" +
    Pattern.quote(word2) + 
    "(\\s|$)";

Pattern p = Pattern.compile(regex);
System.out.println(p.matcher(text).find());
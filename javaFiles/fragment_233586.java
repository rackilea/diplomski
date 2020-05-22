String[] A = {"brown fox", "jumped over the", "lazy dog", "dog", "the", "fish", "quantum burrito", "ox jumped over the laz", "and ate", "ate pie"};
String S = "the quick brown fox jumped over the lazy dog and ate pie";

for(String s : A) {
    Pattern p = Pattern.compile(".*\\b(" +s+ ")\\b.*");
    Matcher m = p.matcher(S);

    while (m.find()) {
        System.out.println(m.matches() + " => " + s);
        System.out.println("    Start index: " + m.start(1));
        System.out.println("    End index: " + m.end(1));
        System.out.println("    Length: " + m.group(1).length());
    }
}
String s = code;
String[] a = s.split("_");
HashMap <String, String> result = new HashMap <String, String>();
for(int i = 0; i < a.length; i++) {
    String [] inner = a[i].split ("L");
    if (inner.length > 1) {
        System.out.printf("%s %s%n", inner [0], inner[1]);
        result.put (inner [0], inner[1]);
    }
}
Map<Integer, String> map = new HashMap<Integer, String>();
map.put(112334,"A");
map.put(221345,"B");
map.put(321411,"C");
map.put(431254,"D");

Collection<String> values = map.values();
for (String str1 : values) {
    for (String str2 : values) {
        if (str1.compareTo(str2) < 0) {
            System.out.println(String.format("unique pair: (%s, %s)", str1, str2));
            // or whatever you want but do not modify map here!
        }
    }
}
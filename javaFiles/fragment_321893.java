String s = "aaabbbccc";

Map<Character, Integer> stringHash = new HashMap<Character, Integer>();
for (char ch : s.toCharArray())
    stringHash.put(ch, stringHash.containsKey(ch) ? (stringHash.get(ch) + 1) : 1);

System.out.println(stringHash);
// output: "{a=3, b=3, c=3}"
Map<Character, Character> charMap = new HashMap<Character, Character>();
charMap.put('ლ', 'A');
charMap.put('ე', 'B');
charMap.put('ჩ', 'C');
charMap.put('ხ', 'D');
charMap.put('უ', 'E');
charMap.put('მ', 'F');
charMap.put('ი', 'G');
String s = "ლეჩხუმი";

for (Character c : s.toCharArray()) {
    if (charMap.get(c) != null)
        s = s.replace(c, charMap.get(c));
}
System.out.println(s);
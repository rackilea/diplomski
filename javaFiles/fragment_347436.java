Map<Character, String> lettersMap = new HashMap<Character, String>();
lettersMap.put(Character.valueOf('A'), "123f");
lettersMap.put(Character.valueOf('B'), "221d");
lettersMap.put(Character.valueOf('H'), "2333gg");

String input = "Hello world";
StringBuffer sb = new StringBuffer();
char[] inputLetters = input.toCharArray();
for (int i = 0; i < inputLetters.length; i++) {
    Character letter = Character.valueOf(inputLetters[i]);
    if (lettersMap.containsKey(letter))
        sb.append(lettersMap.get(letter));
}
System.out.println(sb.toString());
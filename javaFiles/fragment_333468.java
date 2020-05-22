public static void main(String[] args) {
    String x = "qwertyuiopasdfghjkl";
    Map<Character, Integer> charMap = new HashMap<>();
    char c = 'a';
    for (int i = 1; i < x.length(); i++) {
        charMap.put(c++, (int) x.charAt(i));
    }
    System.out.println(charMap.get('a') * charMap.get('b')
                       + charMap.get('c')
                       + charMap.get('d') * charMap.get('e')
                       + charMap.get('f')
                       + charMap.get('g') * charMap.get('h')
                       + charMap.get('i')
                       + charMap.get('j') * charMap.get('k')
                       + charMap.get('l') * charMap.get('m')
                       + charMap.get('n') * charMap.get('o')
                       + charMap.get('p')
                       + charMap.get('q') * charMap.get('r'));
}
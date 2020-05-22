String str = "ABCDEF";
Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('A', 1); put('B', 2); put('C', 3);
            put('D', 4); put('E', 5); put('F', 6);
        }
};
for (char ch: str.toCharArray()) {
    sum += map.get(ch);
}
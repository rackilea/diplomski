public static void main(String args[]) {

    String input = "  Hello        world";
    char[] chars = input.toCharArray();
    int wordCount = 0;

    Map<Character, Integer> map = new LinkedHashMap<>();
    char lastChar = ' ';
    for (char c: chars) {
        if (lastChar == ' ' && c != ' ') wordCount++;
        map.put(c, map.getOrDefault(c, 0) + 1);
        lastChar = c;
    }

    System.out.println("Word Count : " + wordCount);
    map.forEach((k, v) -> {
        System.out.println(k + ": " + v);
    });

}
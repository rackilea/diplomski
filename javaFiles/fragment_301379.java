public static void main(String[] args) {
    Map<Character, Integer> blue = new HashMap<>();

    for (char c = 'a'; c <= 'z'; c++) {
        blue.put(c, (int) c);
    }

    for (Character c : blue.keySet()) {
        System.out.println(c);
    }
}
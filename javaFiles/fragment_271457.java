public static int[] sortInput(String input) {
    input = input.toLowerCase();
    int[] list = new int[26];
    for (int i = 0, len = input.length(); i < len; i++) {
        char ch = input.charAt(i);
        if (ch >= 'a' && ch <= 'z') {
            list[ch - 'a']++;
        }
    }
    return list;
}
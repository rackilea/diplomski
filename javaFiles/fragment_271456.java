public static int[] sortInput(String input) {
    input = input.toLowerCase();
    int[] list = new int[26];
    for (char ch : input.toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
            list[ch - 'a']++;
        }
    }
    return list;
}

public static void main(String[] args) {
    String input = "I bought a car.";
    int[] out = sortInput(input);
    for (int i : out) {
        System.out.print(i);
        System.out.print(" ");
    }
    System.out.println();
}
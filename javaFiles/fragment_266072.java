public static void main(String[] args) {
    String sentence = "Mary Jane and Peter Parker are friends.";
    int trigger = 5; //"Parker"

    int length = 0;
    for (char c : sentence.toCharArray()) {
        if (trigger == 1) break;
        if (c == ' ') trigger--;
        length++;
    }
    System.out.println(length); // prints 20
}
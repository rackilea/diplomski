public static int countit(String word, char ch) {
    int count = 0;
    int index = 0;
    while (index < word.length()) {
        if (word.charAt(index) == ch) {
            count = count + 1;
        }

        index = index + 1;
    }
    return count;
}

public static void main(String argv[]) {

    System.out.println("shit");
    System.out.println(countit("hello", 'e'));
}
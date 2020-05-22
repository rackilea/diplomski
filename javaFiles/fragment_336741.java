private static final int LENGTH = 10000;

public static void main(String[] args) {
    String[] strings = new String[LENGTH];
    for (int i = 0; i < LENGTH; i++) {
        strings[i] = "abc" + i + ".";
    }
    long start = System.currentTimeMillis();
    for (int i = 0; i < strings.length; i++) {
        String word = strings[i];
        word = word.substring(0, word.length()-1);
    }
    long end = System.currentTimeMillis();

    System.out.println("substring: " + (end - start) + " millisec.");

    start = System.currentTimeMillis();
    for (int i = 0; i < strings.length; i++) {
        String word = strings[i];
        word = word.replaceAll(".", "");
    }
    end = System.currentTimeMillis();

    System.out.println("replaceAll: " + (end - start) + " millisec.");

    start = System.currentTimeMillis();
    for (int i = 0; i < strings.length; i++) {
        String word = strings[i];
        word = word.replace(".", "");
    }
    end = System.currentTimeMillis();

    System.out.println("replace: " + (end - start) + " millisec.");

}
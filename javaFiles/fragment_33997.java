public class Main {

public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.decode("SECRET MESSAGE"));
    System.out.println(main.decodeLambda("SECRET MESSAGE"));
}

public static String KEY = "HOPSCOTCH";
public static String ALPHABET = "ABCDEFGHIJKLMONOPQRSTUVWXYZ";

public String decode(String input) {
    StringBuilder letters = new StringBuilder();
    input = input.toUpperCase();
    int i = 0, j = 0;
    while (i < input.length()) {
        char symbol = input.charAt(i);
        char keySymbol = KEY.charAt(j);
        int newIndex = Math.abs(ALPHABET.indexOf(symbol) - ALPHABET.indexOf(keySymbol)) % ALPHABET.length();
        char newSymbol = ALPHABET.charAt(newIndex);
        letters.append(newSymbol);
        j = ++j % KEY.length();
        i++;
    }
    return letters.toString().toLowerCase();
}

public String decodeLambda(String input) {
    StringBuilder letters = new StringBuilder();
    input = input.toUpperCase();
    var ref = new Object() {
        int j = 0;
    };

    input.chars()
            .forEach( symbol -> {
                char keySymbol = KEY.charAt(ref.j);
                int newIndex = Math.abs(ALPHABET.indexOf(symbol) - ALPHABET.indexOf(keySymbol)) % ALPHABET.length();
                char newSymbol = ALPHABET.charAt(newIndex);
                letters.append(newSymbol);
                ref.j = ++ref.j % KEY.length();
            });

    return letters.toString().toLowerCase();
}
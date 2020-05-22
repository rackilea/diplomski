import java.util.Scanner;

class App {
    public static void main(String[] args) {
        final StringBuffer line = new StringBuffer();
        final StringBuffer words = new StringBuffer();

        try (final Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                final String currentLine = sc.nextLine();
                line.append(currentLine).append(System.lineSeparator());
                for (final String word : currentLine.split("\\s+")) {
                    words.append(word).append(System.lineSeparator());
                }
            }
        } finally {
            System.out.println(line.toString());
            System.out.println();
            System.out.println(words.toString());
        }
    }
}
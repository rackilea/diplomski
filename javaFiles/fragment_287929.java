public class ReadOptionsFromUser {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final String FILENAME = "F:/Android.txt";

    public static void main(String[] args) throws FileNotFoundException {
        try (PrintStream output = new PrintStream(FILENAME)) {
            readFromUser(output);
        }
    }

    public static void readFromUser(PrintStream output) {
        String wordA = readLine("Word (a)");
        String wordB = readLine("Word (b)");
        String wordC = readLine("Word (c)");
        String wordD = readLine("Word (d)");
        String answer = readLine("Correct letter");

        output.println(radio("a", wordA, answer));
        output.println(radio("b", wordB, answer));
        output.println(radio("c", wordC, answer));
        output.println(radio("d", wordD, answer));
    }

    private static String readLine(String prompt) {
        System.out.print(prompt + ": ");
        return INPUT.nextLine();
    }

    private static String radio(String letter, String word, String answer) {
        String option = "(" + letter + ") " + word;
        String is = letter.equals(answer) ? "is" : "is not";

        return "<input type='radio' name='rbnNumber' value='You selected " 
                + option + " which " + is +  " the correct answer' />"
                + option + "<br/>";
    }
}
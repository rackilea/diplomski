public class YesNo {

    public static void main(String[] args) {
        if (askYesNo("Do you wish to proceed? (Y/N): ")) {
            System.out.println("Okay...");
        }

        if (askYesNo("Delete all Files? (Okay/Cancel): ", "okay", "cancel")) {
            System.out.println("Make it so");
        }
    }

    public static boolean askYesNo(String question) {
        return askYesNo(question, "[Y]", "[N]");
    }

    public static boolean askYesNo(String question, String positive, String negative) {
        Scanner input = new Scanner(System.in);
        // Convert everything to upper case for simplicity...
        positive = postive.toUpperCase();
        negative = negative.toUpperCase();
        String answer;
        do {
            System.out.print(question);
            answer = input.next().trim().toUpperCase();
        } while (!answer.matches(positive) && !answer.matches(negative));
        // Assess if we match a positive response
        return answer.matches(positive);
    }
}
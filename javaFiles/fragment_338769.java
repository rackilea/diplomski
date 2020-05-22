import java.util.Scanner;

public class Quiz {

    private static final String[] questions = {"I find myself less eager to go back to work or to resume my chores after a weekend.",
            "I feel less and less patient and/or sympathetic listening to other people’s problems.",
            "I ask more “closed-ended questions to discourage dialogue with friends and co-workers than “open-ended” ones to encourage it.",
            "I try to get away from people as soon as I can.",
            "My dedication to work, exercise, diet, and friendships is waning.",
            "I am falling further behind in many of the responsibilities in my life.",
            "I am losing my sense of humor.",
            "I find it more and more difficult to see people socially.",
            "I feel tired most of the time.",
            "I don’t seem to have much fun anymore.",
            "I feel trapped. ",
            "I know what will make me feel better, but I just can’t push myself to do it and I’ll “Yes, but” any suggestions that people make."};

    public static void printSurveyResults(int answerCount) {

        if (answerCount >= 0 && answerCount <= 2) {
            System.out.println("You are more exhausted than stressed out.");
        } else if (answerCount >= 3 && answerCount <= 5) {
            System.out.println("You are beginning to stress out.");
        } else if (answerCount >= 6 && answerCount <= 8) {
            System.out.println("You are possibly stressed out.");
        } else if (answerCount >= 9 && answerCount <= 12) {
            System.out.println("You are probably stressed out.");
        }
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        String response;
        int count = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            response = reader.next();
            if (response.equals("yes")) {
                count++;
            }
        }
        printSurveyResults(count);

    }

}
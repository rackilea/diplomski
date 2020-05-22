import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class testLoader {

    private static BufferedReader br;
    private static int answerCounter = 0;

    public static void main(String[] args) {

        try {
            br = new BufferedReader(new FileReader("C:/Various/test.txt"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            do {
                line = br.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append(System.getProperty("line.separator"));
                } else {
                    break;
                }
                String answer = br.readLine().trim();
                while (!"---".equals(line)) {
                    line = br.readLine();
                    sb.append(line);
                    sb.append(System.getProperty("line.separator"));
                }
                System.out.println(sb.toString());
                answerCheck(answer);
                sb.setLength(0);

            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("You have " + answerCounter + " correct answers");
    }

    public static void answerCheck(String rightAnswer) {
        System.out.println("What's your answer?");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        // answerCounter = 0;
        if (answer.equals(rightAnswer)) {
            answerCounter++;
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

}
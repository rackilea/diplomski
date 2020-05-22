import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadQuestions {

    static ArrayList<Question> mainlist = new ArrayList<>();


    static void readFile(File f) throws IOException {
        FileReader fileReader = new FileReader(f);

        BufferedReader bufferedReader =
                new BufferedReader(fileReader);

        String line;


        while(true) {

            line = bufferedReader.readLine();
            if(line == null)
                break;
            System.out.println(line);
            String question = line;

            line = bufferedReader.readLine();
            int numoptions = Integer.parseInt(line);

            ArrayList<String> options = new ArrayList<>();
            for (int i = 0; i < numoptions; i++) {
                line = bufferedReader.readLine();
                String choice = line;
                options.add(choice);
            }

            line = bufferedReader.readLine();
            int answer = Integer.parseInt(line);

            line = bufferedReader.readLine();
            int tries = Integer.parseInt(line);

            line = bufferedReader.readLine();
            int wins = Integer.parseInt(line);


            Question objQ = new Question(question, numoptions, options,            answer, tries, wins);
            mainlist.add(objQ);
        }
        bufferedReader.close();
    }

    public static void main(String []arg) throws IOException {
        File f = new File("questions.txt");
        readFile(f);
    }


    public static class Question {
        public Question(String question, int numoptions, ArrayList<String> options, int answer, int tries, int wins) {
            // tbc
        }
    }


}
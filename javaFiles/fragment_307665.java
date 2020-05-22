import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HighScore {

    int row;

    int col;

    Scanner input = new Scanner(System.in);

    public void maxscore() {
        System.out.println("How many students are you entering scores for");
        int st_num = input.nextInt();
        String[][] arr = new String[st_num][2]; //you need two columns for Student names AND score
        for (row = 0; row < arr.length; row++) {
            System.out.println("Please enter the student's name");
            arr[row][0] = input.next(); //puts the student name into the first column in every row you have

            System.out.println("Please enter the students's score");
            arr[row][1] = Integer.toString(input.nextInt()); //puts the score into the second column of the row and you need to cast the int to a string
        }
        System.out.println("All scores listed. Highest value at the top: ");

        arr = sortByScore(arr); //sorts the array with created sort method

        for(String[] s : arr) { //goes through the array after its sorted and prints it out
            System.out.println("Students name: " + s[0]);
            System.out.println("Students score: " + s[1]);
        }

        String[][] topScore = new String[1][2]; //will just have the top score

        for(int i = 0; i < topScore.length; i++) { //just goes through one time anyways and then puts the top score onto the topScore array
            topScore[i][0] = arr[0][0]; //the first value is the highest so it takes 0 index
            topScore[i][1] = arr[0][1];
        }



        System.out.println("\nHighest score: ");

        for(String[] s : topScore) { //puts out highest score
            System.out.println("Best students name: " + s[0]);
            System.out.println("Best students score: " + s[1]);
        }
    }
    public static void main(String[] args) {
        HighScore obj = new HighScore();
        obj.maxscore();
    }

    private String[][] sortByScore(String[][] in) {
        String[][] out = Arrays.stream(in) //this uses java 8 streams and takes the in[][] which is in your case the array "arr"
            .sorted(Comparator.comparing(x -> -Integer.parseInt(x[1]))) //sorts it
            .toArray(String[][]::new); //puts it onto the out array

            return out; //and returns the out array back
    }
}
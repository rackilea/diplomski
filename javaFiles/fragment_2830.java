public class TestProgram {
        public static void main(String[] args) throws FileNotFoundException {
            {
                int userThrow, cpuThrow;
                final int ROCK = 1, PAPER = 2, SCISSORS = 3;
                String rockName = "Rock", paperName = "Paper", scissorsName = "Scissors";
                String nameOfGame = "Rock, Paper, Scissors";
                String userThrowEng, cpuThrowEng;
                int outcome;
                int langSel = 1;
                String userInput;
                boolean keepPlaying = true;

                Scanner input = new Scanner(System.in);
                Random generator = new Random();
                LanguageHandler language = new LanguageHandler();

                System.out.println("Select Language");
                System.out.println();
                System.out.println("(1) US\n(2) UK");
                System.out.println();
                System.out.print(">");

                langSel = input.nextInt();

                if (langSel == 2) {
                    nameOfGame=language.getNameOfGame();
                }

                System.out.println("Welcome to " + nameOfGame + "!");
            }
        }
    }

public class LanguageHandler {

     String  nameOfGame = "Paper, Scissors, Stone";
     String rockName = "Stone";
    public String getNameOfGame() {
        return nameOfGame;
    }
    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }
    public String getRockName() {
        return rockName;
    }
    public void setRockName(String rockName) {
        this.rockName = rockName;
    }


}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shuffle {
    public static void main(String[] args) {
        startGame();
    }
    public static void shuffle(String input,String rword) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);

        List<Character> characters = new ArrayList<>();
        for(char c:input.toCharArray()){
            boolean scword = characters.add(c);
        }
        StringBuilder scrmbldword = new StringBuilder(input.length());
        while(!characters.isEmpty()){
            int randPicker = (int)(Math.random()*characters.size());
            scrmbldword.append(characters.remove(randPicker));
        }

        // Game loads the game xD
        System.out.print("\rLoading");
        Thread.sleep(500);
        System.out.print("\rLoading.");
        Thread.sleep(500);
        System.out.print("\rLoading..");
        Thread.sleep(500);
        System.out.print("\rLoading...");
        Thread.sleep(500);
        System.out.print("\rLoading....");
        Thread.sleep(500);
        System.out.print("\rLoading.....");
        Thread.sleep(500);
        System.out.print("\rLoading.....");
        Thread.sleep(100);
        System.out.print("\rCompleted");

        // Game introduces itself to the user.
        Thread.sleep(2000);
        System.out.println("\rWelcome to Scramble PT!");
        Thread.sleep(1000);
        System.out.println("This is a game where you guess a word that is scrambled.");

        // Game request name input from the user
        Thread.sleep(2000);
        System.out.println("First, What is your Name?");
        String name = scanner.next();

        // Game prints name input from the user
        Thread.sleep(2000);
        System.out.println("Hello " + name + ",Please get ready because the game is Starting!");

        // Game ask the user for Y/N input
        Thread.sleep(2000);
        System.out.print("Are you ready?: ");
        String yon = scanner.next();

        switch (yon.toLowerCase()) {
            case "yes":
                // Game prints the Scrambled Word
                System.out.print("Scrambled Word: ");
                System.out.print(scrmbldword.toString());
                // Game let user enter it's guess
                System.out.print("\nEnter your Answer: ");
                String answer;
                boolean win;
                win = false;

                while (!win){
                    answer = scanner.next();
                    if (!answer.equalsIgnoreCase(rword)){
                        System.out.println("Wrong, please Try Again!");
                        Thread.sleep(500);
                        System.out.print("Enter your Answer: ");
                    }else{
                        System.out.println("Correct!");
                        Thread.sleep(500);
                        System.out.print(String.format("Thanks for playing %s!",name));
                        win = true;
                        Thread.sleep(500);
                        System.out.println(" Would you like to try again?");
                        System.out.println("Enter Yes or No: ");
                        String retry = scanner.next();
                        Thread.sleep(500);

                        if (retry.equalsIgnoreCase("Yes")){
                            System.out.println("Alright! reloading the game");
                            startGame();
                            return;
                        }else
                        if (retry.equalsIgnoreCase("No")){
                            System.out.println(String.format("Goodbye! %s !",name));
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down.");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down..");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down...");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down....");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down.....");
                        }else{
                            System.out.println("I can't understand you.... So.... Bye!");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down.");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down..");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down...");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down....");
                            Thread.sleep(200);
                            System.out.println("\rGame Shutting down.....");
                        }break;
                    }
                }
            case "no":
                Thread.sleep(500);
                System.out.print("Ok, Please come again!");
                break;
            default:
                Thread.sleep(500);
                System.out.print("Please answer exactly Yes or No!");
                break;
        }
    }

    public static void startGame() {
        String[] word = new String[22];

        word[0] = "Package";
        word[1] = "Import";
        word[2] = "Public";
        word[3] = "Private";
        word[4] = "Static";
        word[5] = "Void";
        word[6] = "String";
        word[7] = "Integer";
        word[8] = "Character";
        word[9] = "Boolean";
        word[10] = "Public";
        word[11] = "High-Level";
        word[12] = "Low-Level";
        word[13] = "Class";
        word[14] = "Statements";
        word[15] = "Constructor";
        word[16] = "Default";
        word[17] = "Method";
        word[18] = "Declaration";
        word[19] = "Object";
        word[20] = "Variable";
        word[21] = "Null";

        String rword = word[(int) (Math.random() * word.length)];
        try {
            shuffle(rword,rword);
        } catch (InterruptedException ignored) {}
    }

}
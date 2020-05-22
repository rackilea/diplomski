import java.util.Scanner;

        public class MainGame {     

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                boolean found=true;
                boolean playAgain=true;
                int life=8;

                while (playAgain) {

                    System.out.println(" MAIN MENU ");                          
                    System.out.println ("- Start a new Hangman Game (S) ");
                    System.out.println ("- Exit (E) ");
                    System.out.println ("Please enter your choice : ");

                    String answer = sc.nextLine().toUpperCase();   

                    if (answer.equals("E")) {
                    playAgain=false;                  
                    }
                    else {

                        System.out.println ("Give Word");

                        String word = sc.nextLine();
                        word = word.toUpperCase();
                        char[] filler=new char[word.length()];
                        int i =0;
                        while (i<word.length()) {
                            filler[i]='-';
                            i++;
                        }
                        found = true;
                        while (found) {

                            System.out.print("The Random Word is now : "); 
                            System.out.println (filler);
                            System.out.print ("You have "+life);
                            System.out.println (" Lives left");

                            System.out.print ("Your Guess : ");
                            char guess = sc.nextLine().charAt(0) ;
                            guess = Character.toUpperCase(guess);

                            System.out.println (guess);

                            int j=0;
                            if (word.contains(guess+"")) {

                                System.out.println ("The Guess is Correct !!");
                                for (j=0;j<word.length();j++) {

                                    if(word.charAt(j)==guess) {
                                        filler[j]=guess;
                                    }
                                }
                            }
                            else {
                                life--;
                            }

                            if(word.equals(String.valueOf(filler))) {
                                System.out.println ("Congratulations You Won! Your Guessed Word is : "+word);
                                found=false;
                            }

                            if (life==0) {
                            found=false;
                            System.out.println ("Game Over.");}
                        }               
                    }                   
                }           
            }
        }
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Card {

    public static void main(String[] args) {

        System.out.println("How many decks would you like to use?");
        Scanner scanner = new Scanner(System.in);
        int numberOfDecks = scanner.nextInt();
        String[] suit = {" of Diamonds", " of Spades", " of Hearts", " of Clubs"};
        String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] deck = new String[52 * numberOfDecks];
        boolean deckComplete = false;
        //random must have the correct number of elements
        int[] random = new int[52 * numberOfDecks];

        for (int x = 0; x<random.length; x++) {
            random[x] = x;
        }

        Random rndNum = new Random();

        int i = 0;

        for (int count = 0; count <= numberOfDecks; count++){

            for (i = i; i < deck.length; i++) {

                System.out.println("i is " + i);
                //you were doing the same for suit (i/13), but it should be as below
                deck[i] = faces[i % 13] + suit[i % 4];
            }

            //otherwise you are overiding the same values over and over again for each loop
            i = i+52;
        }

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(deck));

        while (deckComplete == false) {

            //depending of number of decks user selects it has more than 52 cards
            for (int j = deck.length; j >= 1; j--) {

                //so the user know what to do
                System.out.println("Just hit enter to contine");    
                String readString = scanner.nextLine(); 
                int randomNumber = rndNum.nextInt(j);

                if (readString.equals("")) {

                    System.out.println(arrayList.get(random[randomNumber]));
                    arrayList.remove(random[randomNumber]);

                    if (j == 1) {

                        deckComplete = true;
                        System.out.println("You are out of cards!");
                    } 
                }
            }
        }
    }
}
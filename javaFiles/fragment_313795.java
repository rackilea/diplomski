package pokemon.pkgcatch;

// All the classes that you've used are imported here.
// Now the compiler knows where to look for their definitions.
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.io.File;

 public class PokemonCatch {

   public static void main(String[] args) throws IOException{
     final String PlayerName;
     int[][] MyPkmn;

     //Create a scanner to read input
     Scanner keyboard = new Scanner(System.in);
     Scanner wildInput = new Scanner(new File("WildPkmn.txt"));
     Scanner myInput = new Scanner(new File("MyPkmn.txt"));

     //Create a random object to roll die
     Random rand = new Random();

     System.out.print("Welcome to the world of Pokemon, Trainer! "
                      + " What is your name? ");
     //Intro. Save playerName variable and create a doc for player's Pkmn
     PlayerName = keyboard.nextLine();
     System.out.println("Here's your first Pokemon. It's a little weak"
                        + " but you'll just have to catch stronger ones.");

     ArrayList<String> PokeBelt = new ArrayList<String>();
             PokeBelt.add("{1, 1, 2, 2, 2, 3}");

     ArrayList<String> WildPkmn = new ArrayList<String>();
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 0, 1, 1, 2, 2}");
             WildPkmn.add("{0, 2, 2, 3, 3, 4}");
             WildPkmn.add("{0, 2, 2, 3, 3, 4}");
             WildPkmn.add("{0, 2, 2, 3, 3, 4}");
             WildPkmn.add("{0, 2, 2, 3, 3, 4}");
             WildPkmn.add("{0, 18, 16, 12, 10, 8}");
             WildPkmn.add("{0, 18, 16, 12, 10, 8}");

     System.out.println("The tall grass has " +
                    WildPkmn.size() +
                    " arrays stored in it.");

     System.out.println("The Ultimate Pokemon is out there somewhere. " +
                  "It's your job to catch it!");

     Collections.shuffle(WildPkmn);
     System.out.println(WildPkmn);

     encounter(WildPkmn); // pass the variable WildPkmn to the encounter
  }

  public static void encounter(ArrayList<String> list /* Now the encounter() method expects a variable of type ArrayList*/){
    Collections.shuffle(list);
    System.out.println(list);
    System.out.println("You take a walk in the tall grass.");
  }
}
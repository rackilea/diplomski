import java.util.Scanner;
import java.util.*;

public class supraCritters {
    public static void main(String [] arguments) {
        Critter nastybat = new Critter();
        nastybat.health = 100;
        nastybat.mood = 50;
        nastybat.hunger = 25;

        System.out.println("Your critter has just been born,");
        System.out.println("here are the stats of your critter.");
        nastybat.checkStats();

        Scanner sChoice = new Scanner(System.in);
        char choice = ' ';
        while (choice != 'q') {
            switch (choice) {
                case 'c': case 'C':
                    nastybat.checkStats();
                    break;
                case 'f': case 'F':
                    nastybat.feed();
                    break;
                case 'p': case 'P':
                    nastybat.play();
                    break;
                case 'r': case 'R':
                    nastybat.read();
                    break;
                case 't': case 'T':
                    nastybat.train();
                    break;
            case 'q': case 'Q':
                System.out.println("good bye");
                    break;
                default:
                System.out.println("invalid entry");
                    break;
            }   
            System.out.println("\nPlease choose a letter");
            System.out.println("[c]heck stats \n[f]eed \n[p]lay \n[r]ead \n[t]rain");
            System.out.println("[q]uit");
            choice = sChoice.next().charAt(0);
        }   
    }
}
import java.util.Arrays;
import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
String[] hand = (scanner.nextLine() + 'u').toUpperCase().split("");
String values = "  23456789TJQKA";
int[] cards = new int[] {values.indexOf(hand[1]), values.indexOf(hand[2])};
Arrays.sort(cards);
int gap = cards[1] - cards[0] - 1;
boolean pair = gap == -1;
boolean suited = hand[3].equals("S");
char[] cards = new char[] {(char)values.charAt(cards[0]), (char)values.charAt(cards[1])};
int handValue = 0;

// adjust value based on pairs, suitedness or connectedness
if (pair) // hand is a pair
    handValue += 10; //or whatever you want
else if (suited) // hand is suited
    handValue += 3; //or whatever you want

if (gap == 0) // hand is no gap
    handValue += 5; //or whatever you want.

if (gap == 1) // hand is one gap
    handValue += 3; //or whatever you want.

if (cards[1] == 'A' && cards[0] == 'K' && suited) // AK suited
    System.out.println("AK Suited!");
else if (cards[1] == 'A' && suited) // Ax suited
    System.out.println("Ax Suited!");
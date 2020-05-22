import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    private int value;

    public void setValue(int diceValue) {
           value = diceValue;
    }

    public int getValue() {
           return value;
    }

    public void roll() {
        //I am not sure how to structure this section
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
    }
}

public class DiceRollOutput {

    public static void main(String[]args) {

        Dice firstDie = new Dice();
        Dice secondDie = new Dice();

        firstDie.roll();
        secondDie.roll();


        System.out.println("Dice 1: "+ firstDie.getValue());
        System.out.println("Dice 2: "+ secondDie.getValue());
    }
}
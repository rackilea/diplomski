import java.util.Scanner;

public class HeroCreation
{
    Scanner input = new Scanner(System.in);

    public int askStrength() {
        return askIntegerAttribute("strength");
    }

    public int askIntelligence() {
        return askIntegerAttribute("intelligence");
    }

    // ask other attribute values

    private int askIntegerAttribute(String attribute) {
        System.out.println("How much " + attribute + " do you want? ");
        int value = input.nextInt();
        System.out.println("Your " + attribute + " is: " + value + "!");
        return value;
    }
}
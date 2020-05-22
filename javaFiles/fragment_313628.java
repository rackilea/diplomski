import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Write a description of class Swords here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Swords extends Item {
    private static ArrayList<String> swordNames = new ArrayList();
    private static HashMap<String, String> swordDesc = new HashMap<String, String>();

    static {
        generateSwordName();
    }

    // instance variables - replace the example below with your own
    private int dmg;

    /**
     * Constructor for objects of class Swords
     */
    public Swords() {
        super(getRandomSword(), "asd", 40, 40, "Item");
        dmg = generateRandom(2, 50);
    }

    public static String getRandomSword() {
        int swordSize = swordNames.size() - 1;
        String randomSwords = swordNames.get(generateRandom(0, swordSize));
        return randomSwords;
    }

    public static int generateRandom(int Start, int End) {
        int START = Start;
        int END = End;
        Random random = new Random();
        long range = (long) END - (long) START + 1;
        long fraction = (long) (range * random.nextDouble());
        int randomNumber = (int) (fraction + START);
        return randomNumber;
    }

    public static void generateSwordName() {
        swordNames.add("Blade of Slimer");
        swordDesc.put("Blade of Slimer",
                new String("Blade of Slimer is a sword forged from the waste of Slimer, surprisingly durable."));
        swordNames.add("Thorny Farris");
        swordDesc.put("Thorny Farris", new String(
                "A rose thorn was accidently dropped into a bottle of Farris, and a majestic sword emerged from the bottle"));
        swordNames.add("The Sword of Leah");
        swordDesc.put("The Sword of Leah", new String(
                " A sword carried by the Leah family for generations, later given the ability to cut through magic."));
        swordNames.add("Grayswandir");
        swordDesc.put("Grayswandir",
                new String("A sword used by Corwin of Amber. Grayswandir is associated with the moon and the night."));
        swordNames.add("Werewindle");
        swordDesc.put("Werewindle",
                new String("A sword used by Brand of Amber. Werewindle is associated with the sun and day."));
        swordNames.add("Dull Sword");
        swordDesc.put("Dull Sword", new String("A dull sword"));

    }

    /**
     * Skriver ut informasjon om itemet.
     */
    public void print() {
        int minDmg = dmg - 2;
        int maxDmg = dmg + 2;
        System.out.println("########################");
        System.out.println("# Name of item: " + super.getName());
        System.out.println("# Item description: " + super.getDesc());
        System.out.println("# Sword damage: " + minDmg + "-" + maxDmg);
        System.out.println("# Item value: " + super.getValue() + " coins");
        System.out.println("# Item weight: " + super.getWeight() + "kg");
        System.out.println("########################");
    }
}
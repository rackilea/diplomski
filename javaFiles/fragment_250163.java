public class Magician {
    private String name, level, supplies;
    private int galleons;   
    private double health;

    public Magician(String name, String level, String supplies) {
        health = 1000;
        galleons = 200;
        this.name = name;
        this.level = level;
        this.supplies = supplies;
    }

    // Let's do some Constructor overloading here
    public Magician(String initialValueString) {
        String[] initialValues = initialValueString.split("#");
        this(initialValues[0], initialValues[1], initialValues[2]);
    }

    public String toString() {
        return "Name: " + name +
         "Level: " + level +
         "Galleons: " + galleons +
         "Health: " + health +
         "Supplies: " + supplies; 
    }
}


public class MagicAndMalice {
    public static void main (String[] args) {
        // Method one
        Magician harry = new Magician("Harry Potter", "apprentice", "Wand");
        System.out.println(harry);
        System.out.println("------------------------\n\n");

        // Method two
        Magician ron = new Magician("Ron Weasley#apprentice#Owl");
        System.out.println(ron);
        System.out.println("------------------------\n\n");
     }
}
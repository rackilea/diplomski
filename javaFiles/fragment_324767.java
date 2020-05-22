public class Sword {
    // private (so no one can access it but Sword)
    // static (so it belongs to the class Sword and not any specific Sword)
    private static int numberOfSwords = 0; // initialize to 0
    // public accessor method
    public static int getNumberOfSwords() {
        return numberOfSwords;
    }
    // notice there's no "setNumberOfSwords" - no one can come along and change
    // our data - it's 'encapsulated' in the class

    private String name; // private
    private int damage; // private

    public Sword(String name, int damage) {
        this.name = name;
        this.damage = damage;
        numberOfSwords++; // the only place we change number of swords
    }

    // this is how people outside Sword access the name
    // note that we could add a "setName(String name)" if we want
    public String getName() {
        return name;
    }

    // same with name - protect and provide an accessor
    public int getDamage() {
        return damage;
    }
}
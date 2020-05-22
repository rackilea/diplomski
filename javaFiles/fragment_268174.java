// Adjective interface
// Classes can implement as many of these as they like
interface Coloured {
    String getColour();

    // These are examples of how you could implement alternatives to using equals()
    default boolean sameColour(Coloured c) {
        return sameColour(this, c);
    }
    static boolean sameColour(Coloured a, Coloured b) {
        if (a.getColour().equals(b.getColour()) {
            return true;
        } else {
            return false;
        }
    }
    static List<Coloured> sort(List<Coloured> list) {
        // …
    }
    static boolean compare(List<Coloured> a, List<Coloured> b) {
        // …
    }
}

// Noun interface
// Classes should only implement one of these at most
interface Dog extends Coloured {
    String woof();
}

abstract class AbstractDog implements Dog {
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Dog)) {
            return false;
        }
        final Dog d = (Dog) o;
        return d.woof().equals(this.woof()) &&
            d.getColour().equals(this.getColour());
    }
}

class GoldenRetriever extends AbstractDog {
    public String woof() {
        return “RuffRuff”;
    }
    public String getColour() {
        return “Gold”;
    }
}

class ChocolateLabrador extends AbstractDog {
    public String woof() {
        return “WoofLick”;
    }
    public String getColour() {
        return “Chocolate”;
    }
}

class GoldRing implements Coloured {
    public String getColour() {
        return “Gold”;
    }
}

final Coloured obj1 = new GoldenRetriever();
final Coloured obj2 = new GoldRing();
// I know these are Coloured objects but I do not know their implementation
// But because Coloured is an adjective I know not to use equals()
final boolean isSameColour = obj1.sameColour(obj2); // Returns true for same colour but different types

final Dog dog1 = new GoldenRetriever();
final Dog dog2 = new ChocolateLabrador();
// I know these are Dog objects but I do not know their implementation
// But because Dog is a noun I know I can use equals()
// The objects have different implementations but have the same common complete interface
final boolean isEqualDog = dog1.equals(dog2);
final boolean isDogSameColour = Coloured.sameColour(dog1, dog2);
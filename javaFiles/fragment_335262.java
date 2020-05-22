import java.util.ArrayList;
import java.util.List;


class Billfold {
    List<Card> list = new ArrayList<Card>(10);

    void addCard(Card card) // Q: Not sure if this should be String
                            // A: You would like to add a Card
    {
        list.add(card);
    }

    void showAllFormat() {
        // go polymorphism !...
        // when you call this general 'format()' you see the subclasses
        // 'format()' is executed, not from 'Card' class
        for(Card x: list) {
            System.out.println(x.format());            
        }
    }
}

class Card {
    private String name; /* owner */

    public Card() //This is my superclass
    {
        name = "";
    }

    public Card(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean isExpired() {
        return false;
    }

    public String format() {
        return "Card holder: " + name;
    }
}

class IDCard extends Card {
    //This is one of my subclasses
    private int IDNumber;

    public IDCard(String n, int id) {
        super(n);
        this.IDNumber = id;
    }

    public String format() {
        return "(ID)" + super.format() + " " + IDNumber;
    }
}

class DriverLicense extends Card {
    private String type;

    public DriverLicense(String n, String type) {
        super(n);
        this.type = type;
    }

    public String format() {
        return "(DL)" + super.format() + " TYPE: " + type;
    }
}

public class BillfoldTester {
    public static void main(String[] args) {

        Card x = new IDCard("Julie", 1995);
        Card j = new DriverLicense("Jess", "AB");

        Billfold bf = new Billfold();
        bf.addCard(x);
        bf.addCard(j);

        bf.showAllFormat();
    }
}
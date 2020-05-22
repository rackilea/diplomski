public class Computer {
    int id;
    int bet;
    int guess;
    int cash;
    static Computer[] c;

    public static void create(int numComps) {
        c = new Computer[numComps];

        for (int i = 0; i < numComps; i++) {
            c[i] = new Computer();
            c[i].id = i;
            c[i].cash = Game.startCash;
            c[i].bet = bet();
            c[i].guess = guess();
            c[i].display();
        }
    }

    public static int bet() {
        return Rng.rand(Game.startCash / 50) * 50;
    }

    public static int guess() {
        return Dice.roll();
    }

    public void display() {
        String name = "Computer ";
        System.out.println("My name is " + name + id + " bet " + bet + " and guess " + guess);
    }
}
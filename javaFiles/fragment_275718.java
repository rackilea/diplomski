public class Tree {
    public double suitability = Math.random();
    public int id;
    public static int count = 1;

    public Tree(double suitability, int id) {
        this.id = count;
        count++;
    }

    public double getSuit() {
        return suitability;
    }

    public void setSuit(double suitability) {
        this.suitability = suitability;
    }

    public void measureSuit() {
        System.out.println("Tree number " + id + " has a suitability of " + suitability);
    }

    @Override
    public String toString() {
        return "I am the tree with id " + id;
    }
}
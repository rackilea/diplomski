public class Player
{
    private ArrayList<Card> hand;
    private double cash;
    private String name;

    public Player(String playerName, double startingCash)
    {
        hand = new ArrayList<Card>();
        cash = startingCash;
        name = playerName;
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public int totalHand()
    {
        int total = 0;
        for(Card c : hand)
        {
            total += c.getValue();
        }
        return total;
    }

    public void printHandTotal()
    {
        System.out.println(name + "'s' total hand is currently " + totalHand() + ".");
    }

    public String getName()
    {
        return name;
    }

    public double getCash()
    {
        return cash;
    }

    public void setCash(double cash)
    {
        this.cash = cash;
    }
}
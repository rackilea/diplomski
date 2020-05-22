public class BlackJack
{
    private Deck deck;
    private Player me;
    private Player dealer;

    public static void main(String[] args)
    {
        BlackJack game = new BlackJack();
        game.run();
    }

    public BlackJack()
    {
        deck = new Deck();
        deck.shuffle();
        me = new Player("Joe", 1000.0);
        dealer = new Player("Dealer", 0);
    }

    public void run()
    {
        double bet = requestBet(me);

        // Deal your first two cards
        dealNextCard(me, "Your first card is ");
        dealNextCard(me, "Your second card is ");
        me.printHandTotal();

        // Deal dealer's first card
        dealNextCard(dealer, "Dealer showing ");

        while(requestHitOrStay())
        {
            dealNextCard(me, "Your next card is ");
            me.printHandTotal();

            if(me.totalHand() == 21)
            {
                System.out.println(me.getName() + " wins!");
                rewardBet(me, bet);
                System.exit(0);
            }
            else if(me.totalHand() > 21)
            {
                System.out.println(me.getName() + " bust!");
                System.exit(0);
            }
        }

        while(dealer.totalHand() < 17)
        {
            dealNextCard(dealer, "Dealer draws ");
            dealer.printHandTotal();

            if(dealer.totalHand() == 21)
            {
                System.out.println(dealer.getName() + " wins!");
                System.exit(0);
            }
            else if(dealer.totalHand() > 21)
            {
                System.out.println(dealer.getName() + " bust. You win!");
                rewardBet(me, bet);
                System.exit(0);     
            }
        }

        if(me.totalHand() > dealer.totalHand())
        {
            System.out.println("You win!");
            rewardBet(me, bet);
        }
        else if(me.totalHand() < dealer.totalHand())
        {
            System.out.println("Loooooser");
        }
        else
        {
            System.out.println("Push. Nobody wins");
        }
    }

    public boolean requestHitOrStay()
    {
        System.out.print("Hit or Stay? ");
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase().equals("hit");
    }

    public void dealNextCard(Player p, String prefix)
    {
        Card c = deck.dealCard();
        System.out.println(prefix + c);
        p.addCard(c);
    }

    public double requestBet(Player p)
    {
        Scanner in = new Scanner(System.in);
        double bet = Integer.MAX_VALUE;
        while(bet > p.getCash())
        {
            System.out.print("Wager a bet: ");
            bet = in.nextDouble();
        }
        p.setCash(p.getCash() - bet);
        System.out.println(p.getName() + " wagered " + bet + ". " + "Now they have " + p.getCash() + " cash left.");
        return bet;
    }

    public void rewardBet(Player p, double bet)
    {
        p.setCash(p.getCash() + bet * 2);
        System.out.println(p.getName() + " now has " + p.getCash() + " cash.");
    }
}
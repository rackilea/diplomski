public abstract class CardSet<C extends Collection<Card>>
{
    protected final C elCollection;
    public CardSet<Collection<Card>> cardSet()
    {
        return new CardSet<Collection<Card>>(new ArrayList<Card>());
    }
    public CardSet(C col){
        this.elCollection = col;
    }
    public CardSet(C col, Card[] cards)
    {
        this(col);
        for(Card c: cards)
            elCollection.add(c);
    }
    public void add(Card c)
    {
        elCollection.add(c);
    }
}
public class Pair extends CardSet<List<Card>> 
{
    public Pair()
    {
        super(new ArrayList<Card>());

    }
    public Pair(Card[] cards)
    { 
        super(new ArrayList<Card>(), cards);
    } 
}
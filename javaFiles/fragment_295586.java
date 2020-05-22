public Card getCard( int i ){
    return deck[i];
}

public Iterator<Card> iterator(){
    return new DeckIterator( this );
}

public class DeckIterator implements Iterator<Card> {
    private Deck d;
    private int pos;
    DeckIterator( Deck d ){
        this.d = d;
    }

    @Override
    public boolean hasNext(){
        return pos < d.deck.length;
    }

    @Override
    public Card next(){
        if( pos >= d.deck.length ){
            throw new NoSuchElementException( "no more cards in deck" );
        }
        return d.getCard( pos++ );
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException( "not implemented" );
    }
}
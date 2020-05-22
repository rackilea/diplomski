@Override
public boolean equals(Object o) {
    if(o == null)
        return false;

    // in case you tried to compare a Card with a Not-a-Card object
    if(!o instanceof Card) 
        return false;

    Card c = (Card) o;

    return rank.equals(c.rank) && suit.equals(c.suit) && val == c.val;
}
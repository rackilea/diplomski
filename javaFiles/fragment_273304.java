@Override
public boolean equals(Object otherObject)
{
    if (otherObject == null)
    {
        return false;
    }
    if (!(otherObject instanceof PlayingCard))
    {
        return false;
    }
    if (this == otherObject) {
        return true;
    }
    PlayingCard other = (PlayingCard) otherObject;
    return suit.equals(other.suit) && rank == other.rank;
}
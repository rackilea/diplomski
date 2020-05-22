@Override
public String toString ( )
{
    String s = "Rank: " + rank + "Suit: " + suit;

    //call totalValue() to calculate totalValue
    totalValue();

    for (int i = 0; i < numCards; ++i)  {
        //now you can use totalValue, because it's been calculated in totalValue()
        s += "\n" + theCards[i] + "\n" + totalValue;
    }

    return s;
}
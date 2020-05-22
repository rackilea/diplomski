lastCardDealt = deck.length; // start at last index +1

public static Card dealCard(Card[] d){
    lastCardDealt = lastCardDealt - 1;
    return deck[lastCardDealt];
}
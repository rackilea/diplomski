public int compareTo (Card aCard){
    int suitCompare = this.aSuit.compareTo(aCard.aSuit);
    if (suitCompare != 0)  {
        return suitCompare;
    }
    return this.aNumeral.compareTo(aCard.aNumeral);
}
public int totalValue() {
    //removed "int", so you are not declaring local totalValue variable
    //but using your class variable  
    totalValue = 0;
    for (Card card : theCards) {
        totalValue += card.getRank().getRankValue();

    }
    return totalValue;
}
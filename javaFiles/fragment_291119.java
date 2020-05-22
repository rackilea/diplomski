Player player3 = new Player();
    ...
    player3.addCard(deck[2]);
    // deck[0]
    ...
    player3.addCard(deck[6]);
    // deck[1]
    ...
    int p3 = player3.getCardValue(2);
    // get value at deck[2]

    // this goes to ->
    public int getCardValue(int a)  
    {
        // try to access deck[2], but deck only has 
        // 2 valid entries deck[0] and deck[1]
        cValue = deck[a].Value();
        return cValue;
    }
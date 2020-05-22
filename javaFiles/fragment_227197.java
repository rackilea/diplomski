Deck()
{
    deck = new ArrayList<>();

    for(int i=0; i<4; i++)
    {
        for(int j=1; j<=13; j++)
        {
            deck.add(new Card(i,j));
        }  
    }
}
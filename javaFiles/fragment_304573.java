for(int i=0;i<deck.size;++i)
{
    int othercard=randomNumberFrom0To51();
    Card swap=deck[i];
    deck[i]=deck[othercard];
    deck[othercard]=swap;
}
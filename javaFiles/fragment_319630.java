public Card PlayerCardDraw ()
{
    Random generator = new Random ();
    if(cards.size() > 0) {
        int index = generator.nextInt (cards.size());
        return cards.remove (index);
    } else {
        return null;
    }
}
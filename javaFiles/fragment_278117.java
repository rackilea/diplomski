@Test
public void test()
{
    Card aceOfSpades = new Card(Rank.ACE, Suit.SPADES);
    Card fourOfClubs = new Card(Rank.FOUR, Suit.CLUBS);

    assertTrue(aceOfSpades.compareTo(fourOfClubs) > 0));
}
public class CardTest {
    @Test
    public void cardConstructionWhenRandomIsZero() {
        // Given custom random generator which returns always 0.
        Card.randomGenerator = () -> 0;

        // When
        Card actualCard = new Card();

        // Then
        Assert.assertEquals("2", actualCard.value.face);
        Assert.assertEquals(0, actualCard.value.numeric);
        Assert.assertEquals(Suite.CLUBS, actualCard.suit);
    }

    @Test
    public void cardConstructionWhenRandomIsOne() {
        // Given custom random generator which returns always 1.
        Card.randomGenerator = () -> 1;

        // When
        Card actualCard = new Card();

        // Then
        Assert.assertEquals("3", actualCard.value.face);
        Assert.assertEquals(0, actualCard.value.numeric);
        Assert.assertEquals(Suite.CLUBS, actualCard.suit);
    }
}
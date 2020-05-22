@Test
public void cardConstructionWithRealRandom() {
    // When
    Card actualCard = new Card();

    // Then
    Assert.assertThat(actualCard.value.face, Matchers.isIn(Card.supportedFs));
}
@Mock
Supplier<Integer> mockedRandomGenerator;

@Test
public void cardConstructionWhenRandomIsZero() {
    // Given custom random generator which returns always 0.
    Card.randomGenerator = mockedRandomGenerator;
    Mockito.when(mockedRandomGenerator.get()).thenReturn(0);

    // When
    Card actualCard = new Card();

    // Then
    Assert.assertEquals("2", actualCard.value.face);
    Assert.assertEquals(0, actualCard.value.numeric);
    Assert.assertEquals(Suite.CLUBS, actualCard.suit);
}
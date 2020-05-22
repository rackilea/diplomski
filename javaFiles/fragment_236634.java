private CardRandomiser mockCard(final Suit suit, final Face face) {
    CardRandomiser rand = mock(CardRandomiser.class);

    when(rand.getCard(any(Suit.class))).thenAnswer(new Answer<Card>() {
        @Override
        public Card answer(InvocationOnMock invocation) throws Throwable {
            if(!suit.equals(invocation.getArguments()[0])) {
                 throw new IllegalArgumentException(
                         String.format("Value %s passed, but mocked for %s", invocation.getArguments()[0], suit));
            }
            return new Card(suit, face);
        }
    });

    return rand;
}
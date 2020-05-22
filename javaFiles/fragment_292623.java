@Test
    public void testGameConstruction() {

        Hand handMock1 = Mockito.mock(Hand.class);
        Hand handMock2 = Mockito.mock(Hand.class);
        Game game = new Game(handMock1, handMock2);

        verify(handMock1, times(1)).hit();
        verify(handMock2, times(1)).hit();

    }
@Test 
public void shouldUpdateGraphicsToGameOver(){
    Graphics gMock = Mockito.mock(Graphics.class);
    //expectations
    Color expectedColor = Color.white;
    Font expectedFont= ...;
    String expectedMsg = ...;
    int expectedWidth = ...;
    int expectedHeight = ...;

    classUnderTest.gameOver(gMock);

    Mockito.verify(gMock).setColor(expectedColor);
    Mockito.verify(gMock).setFont(expectedFont);
    Mocktio.verify(gMock).drawString(expectedMsg, expectedWidth, expectedHeight);
}
...
@Mock
SandBox mockSandBox;

@Mock
Sand sand;

@Test
public void should(){
    when(mockSandBox.getSand()).thenReturn(sand);
    when(sand.doA()).thenReturn(1);
    when(sand.doB()).thenReturn(1);
    when(sand.doC()).thenReturn(1);
...
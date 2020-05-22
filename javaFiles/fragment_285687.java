@Test
public void process_shouldCatchException() throws Exception{
    UnsubscribeXmlTransformer sut = new UnsubscribeXmlTransformer();
    Map<String, Object> requestMap = Mockito.spy(new HashMap<>());
    when(requestMap.put(eq("unsubscribeDetailsVO"), any()))
        .thenThrow(IOException.class);
    assertThatCode(() -> sut.process(requestMap))
        .doesNotThrowAnyException();
}
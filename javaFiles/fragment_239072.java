@Test
public void testLogging() {
  final List<?> mockList = mock(List.class, withSettings().verboseLogging());
  when(mockList.size()).thenReturn(6);

  mockList.size();
}
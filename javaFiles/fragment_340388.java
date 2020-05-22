@Test
public void test() {
   PowerMockito.mockStatic(A.class);
   Mockito.when(A.secondMethod(Mockito.anyString(), Mockito.anyInt())).thenReturn(1000);
   //1000 was returned by your mocked method
   assertEquals(1000, A.firstMethod("test") );
   PowerMockito.verifyStatic();
}
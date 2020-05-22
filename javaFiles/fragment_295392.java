@Test
public void testListABC() {
    // Mock the ABCDAO
    ABCDAO abcDao = Mockito.mock(ABCDAO.class);

    // Create an A instance using it
    A a = new A(abcDao);

    // Call a's method
    a.listABCElement("",true);

    // Verify the correct method of abcDao was called 
    Mockito.verify(abcDao).getABC("", true);

    // Verify no other methods were called on abcDao
    Mockito.verifyNoMoreInteractions(abcDao);
}
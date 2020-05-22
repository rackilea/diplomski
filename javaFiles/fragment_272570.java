@Captor ArgumentCaptor<String> stringCaptor;

// ...

@Test public void myTest() {

    // ...

    verify(myobject, 6).println(stringCaptor.capture());
    assertEquals("", stringCaptor.getAllValues()[2]);
    assertEquals("myfolder", stringCaptor.getAllValues()[3]);
    assertEquals("", stringCaptor.getAllValues()[4]);    
    assertEquals(System.getProperty("user.home"), stringCaptro.getAllValues()[5]);
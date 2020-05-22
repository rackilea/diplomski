//  create mock
    YourBackgroundService test = Mockito.mock(YourBackgroundService.class);

    // define return value for method getSerial()
    when(test.getSerial()).thenReturn("42UNIV");

    // use mock in test....
    assertEquals(test.getSerial(), "42UNIV");
Ticket mock= Mockito.mock(Ticket.class);
    when(mock.getDescription()).thenReturn("hello");
    when(mock.getEmail()).thenReturn("me@helloooo.com");
    Assert.assertNotNull(mock);
    Assert.assertNotNull(mock.getDescription());
    Assert.assertNotNull(mock.getEmail());

}
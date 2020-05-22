@Test
  public void allAccountsHTMLunitTest() throws Throwable {

    Request req = mock(Request.class);
    when(req.type()).thenReturn(MediaType.html);

    Result result = new MockRouter(new App(), req)
        .get("/allAccounts");

    View view = result.get();
    assertEquals("display", view.name());
    assertEquals("{accounts=[1, 2]}", view.model().toString());

  }
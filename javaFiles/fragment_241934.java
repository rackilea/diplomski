public void testDoAuthorization(){
    final HttpSession session = context.mock(HttpSession.class);

    context.checking(new Expectations(){{
        // ???
    }});

    assertTrue(dwnLoadCel.doAuthorization(session));
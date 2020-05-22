public testCreateUser(){
    Session session = mock(Session.class);
    Transaction trans = mock(Transaction.class);

    when(session.beginTransaction()).thenReturn(trans);

    obj.createUser(session);

    verify(session).save(obj);
    verify(session).close();
    verify(trans).commit();
}
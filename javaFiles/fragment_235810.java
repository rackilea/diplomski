String userName = usr.getUserName(); // or whatever you stubbed, directly
when(myObject.getEntity(
    eq(1l), 
    or(eq(userName),eq(Constants.ADMIN))
    )
).thenReturn(null);
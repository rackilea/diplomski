Credentials credentials = new Credentials("user");
    Credentials credentials1 = Mockito.spy(credentials);
    Mockito.doReturn(pwdCreds).when(credentials1).getCredentials();
    Mockito.doReturn("cmApptest").when(credentials1).getUserName();

    Search search = new Search("username", jsonobject, credentials1);
    search.getDOB();
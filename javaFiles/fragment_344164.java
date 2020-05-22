Authent authent = Mockito.mock(Authent.class);
// record behavior for the mock
when(authent.getPassword()).thenReturn("testPW");

// create the object under test with the mock
this.subject = new Subject(authent);

// call your method to test
this.subject.methodA(name);

// do your assertions
...
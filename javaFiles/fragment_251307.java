@Test(expected=IllegalArgumentException.class)
public void testNoDuplicateUsers() {
  User sampleUser = new User("1");
  UserDB delegate = mock(UserDB.class);
  when(delegate.getUser(any(User.class))).thenReturn(sampleUser);
  UserDB db = new ValidatingUserDB(delegate);
  db.addUser(sampleUser);
}

public void testAddingUser() {
  User sampleUser = new User("1");
  UserDB delegate = mock(UserDB.class);
  UserDB db = new ValidatingUserDB(delegate);
  db.addUser(sampleUser);
  verify(delegate).getUser(sampleUser);
  verify(delegate).addUser(sampleUser);
}
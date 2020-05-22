Iterator<User> it = users.values().iterator();
while (it.hasNext())
{
  User currentUser = it.next();
  currentUser.someMethod();
}
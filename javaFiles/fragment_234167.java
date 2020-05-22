Object o = in.readObject();

if (o instanceof SomeUserRequest)
{
  SomeUserRequest sur = (SomeUserRequest)o;
  ..
}
else if (o instanceof OtherUserRequest)
{
  ..
}
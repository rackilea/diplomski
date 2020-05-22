public static Foo fromBytes(byte[] bytes)
{
  Foo tmp = Foo.getSchema().newMessage();
  ProtostuffIOUtil.mergeFrom(bytes, tmp, Foo.getSchema());
  return tmp;
}
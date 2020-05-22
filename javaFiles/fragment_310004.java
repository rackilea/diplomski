public static byte[] toBytes(Foo o)
{
  LinkedBuffer BUFFER = LinkedBuffer.allocate(1024*1024);
  Schema<Foo> SCHEMA = Foo.getSchema();
  return ProtostuffIOUtil.toByteArray(o, SCHEMA, BUFFER);
}
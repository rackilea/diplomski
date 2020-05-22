void doSomething(OutputStream os)
{
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    bos.write(something);
    bos.close();
    byte[] arr = bos.toByteArray();
    // what do you want to do?
    os.write(arr); // or: bos.writeTo(os);
...
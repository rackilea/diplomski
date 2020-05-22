Object obj = // something

FileOutputStream fos = // an initialized stream

ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bos);
oos.writeObject(obj);
oos.flush();

if (bos.size() > MAX_ALLOWED_SIZE)
   throw // or log, or whatever you want to do
else
{
    fos.getChannel().position(writeLocation);
    bos.writeTo(fos);
}
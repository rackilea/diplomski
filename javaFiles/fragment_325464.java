ByteArrayInputStream is = new ByteArrayInputStream(new BigInteger(
    "aced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007e2060c78", 16)
      .toByteArray());
is.read();
ObjectInputStream ois = new ObjectInputStream(is);
final Object obj = ois.readObject();
System.out.println(obj+" ("+obj.getClass().getName()+')');
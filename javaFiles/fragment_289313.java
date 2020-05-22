//Using reflection
Class classObj Class.forName("Foo");
Foo obj1 (Foo)classObj.newInstance();

//new operator
Foo obj2 new Foo();

//cloning
Foo obj3 (TestObjectCreation)obj1.clone();

//deserialization
ByteArrayOutputStream baos new ByteArrayOutputStream();
ObjectOutputStream oos new ObjectOutputStream(baos);
oos.writeObject(obj1);
ByteArrayInputStream bais new ByteArrayInputStream(baos.toByteArray());
ObjectInputStream ois new ObjectInputStream(bais);
Foo obj4 (Foo)ois.readObject();
obj4.method1();
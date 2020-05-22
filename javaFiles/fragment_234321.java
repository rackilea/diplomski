Class<?> c = Class.forName("package1.A");
//full package name --------^^^^^^^^^^
//or simpler without Class.forName:
//Class<package1.A> c = package1.A.class;

//In our case we need to use
Constructor<?> constructor = c.getDeclaredConstructor();
//note: getConstructor() can return only public constructors
//so we needed to search for any Declared constructor

//now we need to make this constructor accessible
constructor.setAccessible(true);//ABRACADABRA!

Object o = constructor.newInstance();
Class c = Class.forName("foo.Bar");
Object newInstance = c.newInstance();
Method method = c.getMethod("doSomething", String.class);
// This will locate the first method
method.invoke(newInstance, "Hello World");

Method method = c.getMethod("doSomething", String[].class, String.class);
// This will locate the second method

String [] arr = {"Hello", "World"};
method.invoke(newInstance, arr, "Hello World");
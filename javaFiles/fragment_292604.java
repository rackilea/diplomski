List<String> list = new ArrayList<String>();
list.add("Foo");

// toArray doesn't know the type of array to create
// due to type erasure
Object[] array = list.toArray();

// This cast will fail at execution time
String[] stringArray = (String[]) arrray;
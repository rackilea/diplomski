Multimap<String, String> myMultimap = ArrayListMultimap.create();

  // Adding some key/value
  myMultimap.put("Fruits", "Banana");
  myMultimap.put("Fruits", "Apple");
  myMultimap.put("Fruits", "Pear");
  myMultimap.put("Vegetables", "Carrot");

  // Getting the size
  int size = myMultimap.size();
  System.out.println(size);  // 4

  // Getting values
  Collection<string> fruits = myMultimap.get("Fruits");
  System.out.println(fruits); // [Bannana, Apple, Pear]

  Collection<string> vegetables = myMultimap.get("Vegetables");
  System.out.println(vegetables); // [Carrot]
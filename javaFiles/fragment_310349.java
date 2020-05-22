ObjectOutputStream output = new ObjectOutputStream(bufferedSocketStream);

  output.writeInt(42); // Write a primitive integer
  output.writeObject("Hello World"); // Write a string as an object
  output.writeObject(myClass); // Write a class instance that you've implemented the "Serialize" interface

  output.flush();

  /* INPUT */
  ObjectInputStream inputStream = new ObjectInputStream(bis);
  int value = inputStream.readInt(); // Will receive 42
  Object value2 = inputStream.readObject(); // Will receive "Hello World"
  Object value3 = inputStream.readObject(); // Will receive your serialized class instance
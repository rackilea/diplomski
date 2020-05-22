int[][][][] data = new int[10][10][10][10];

// Write object to a file
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("serializedArray.data")));
oos.writeObject(data);
oos.flush();
oos.close();

// Read an object from a file
ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("serializedArray.data")));
Object obj = ois.readObject();
ois.close();

// Cast it back to an int array
data = (int[][][][])obj;
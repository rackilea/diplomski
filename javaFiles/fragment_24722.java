int[][] intArray = new int[5][5];
//Code to populate array

// serialize array
FileOutputStream fos = new FileOutputStream("array.dat");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(intArray);
File fileToReadObject=new File("path");
Object objectToRead;

FileInputStream fileIn = new FileInputStream(fileToReadObject);
ObjectInputStream in = new ObjectInputStream(fileIn);

objectToRead= (Object) in.readObject();  // It will return you the saved object

in.close();
fileIn.close();
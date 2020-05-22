public void readPositions() throws IOException, ClassNotFoundException {
  File file = new File("positions.ser");
  FileInputStream inFile = new FileInputStream(file);
  ObjectInputStream inStream = new ObjectInputStream(inFile);
  Position[] toTown = (Position[]) inStream.readObject());
  for(int i = 0; i < toTown.length; i++) {
    System.out.println(toTown[i]);
  }
  inStream.close();
  inFile.close();
  file.delete();
}
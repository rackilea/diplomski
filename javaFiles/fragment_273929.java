public void writePositions() throws IOException, ClassNotFoundException {
  File file = new File("positions.ser");
  FileOutputStream outFile = new FileOutputStream(file);
  ObjectOutputStream outStream = new ObjectOutputStream(outFile);
  public Position[] toTown = new Position[] {
      new Position(3094, 3491, 0), 
      new Position(3088, 3487, 0),
      new Position(3080, 3475, 0)};
  outStream.writeObject(toTown);
  outStream.close();
  outFile.close();
}
public void writePositions() throws IOException, ClassNotFoundException {
  ...
  public Position[] toTown = new Position[] {
      new Position(3094, 3491, 0), 
      new Position(3088, 3487, 0),
      new Position(3080, 3475, 0)};
  outStream.writeObject(toTown); //Write the array of Position
  boolean selected = boxRandomMouse.isSelected();
  outStream.writeObject(selected); //Write the Boolean Object
  ...
}

public void readPositions() throws IOException, ClassNotFoundException {
  ...
  Position[] toTown = (Position[]) inStream.readObject()); //Read the array of Position which was written first
  for(int i = 0; i < toTown.length; i++) {
    System.out.println(toTown[i]);
  }
  boolean selected = (boolean) inStream.readObject(); //Read the Boolean value which was written in the second order
  // And so on
  ...
}
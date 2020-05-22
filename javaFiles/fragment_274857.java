interface Instruction {}

class LocationInstruction implements Instruction { 
    int locationId;
    public String toString() { return "Go to the location " + locationId; } ;
}

class ItemInstruction implements Instruction {
    Item item;
    public String toString() { return "Pick item " + item.toString(); } ;
}

class Item {
  int itemId;
  ...
  public String toString() { return "Item{itemId: "+itemId+"}" ;}
}

class Actions {
  public List<Instruction> getInstructions();
}
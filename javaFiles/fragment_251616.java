abstract class Item{
  private PImage texture;
  private int durability;
  private int maxDurability;

  private String name;

  public Item(String name){
      this.name = name;
   }
}

class Armor extends Item{
  private int defense;

  Armor(){
    super("Armor");
  }
}
public enum Item {

  GOLD(2, "gold"), SILVER(12, "silver"), BRONZE(5, "bronze");     

  private int weight;
  private String description;

  private Item(int weight, String description) {
    this.weight = weight ;
    this.description = description ;
  }

  // rest of code

}
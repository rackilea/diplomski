//Definition of the enum
enum ItemType {
  First("First choice"), Second("Second choice"), Third("Final choice");
  private final String display;
  private ItemType(String s) {
    display = s;
  }
  @Override
  public String toString() {
    return display;
  }
}


//Assigning values of enum to 'play' JComboBox
play.setModel(new DefaultComboBoxModel(ItemType.values()));

//Reading the value of JComboBox
ItemType selectedType = (ItemType)play.getSelectedItem();
gGame.setPlayer(selectedType); //toString is overridden, so it will assign the appropriate text value of the enum
private CompositeCell<ObjectRow> createCompositeCell(){

HasCell<ObjectRow, String> button1 = new HasCell<ObjectRow, String>() {

  public Cell<String> getCell() {
    return new ButtonCell();
  }

  public FieldUpdater<ObjectRow, String> getFieldUpdater() {
    return null;
  }

  public String getValue(ObjectRow object) {
    return "Button 1";
  }};

  HasCell<ObjectRow, String> button2 = new HasCell<ObjectRow,String>(){

    public Cell<String> getCell() {
      return new ButtonCell();
    }

    public FieldUpdater<ObjectRow, String> getFieldUpdater() {
      return null;
    }

    public String getValue(ObjectRow object) {
      return "Button 2";
    }
  };

  List<HasCell<ObjectRow, ?>> cells = new ArrayList<HasCell<ObjectRow, ?>>();
  cells.add(buton1);
  cells.add(button2);

  CompositeCell<ObjectRow> compositeCell = new CompositeCell<ObjectRow>(cells);

  return compositeCell;
}
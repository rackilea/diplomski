class Foo {
  private int id;
  private String name;
  private Data data;

  static class Data {
    List<Item> items;
  }

  public int getId() { return id; }
  public String getName() { return name; }     
  public List<Item> getItems() { return data.items; }
}
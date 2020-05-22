public class MyAction extends ActionSupport implements ModelDriven<MyModel>, Preparable {

  public void prepare() {
    myModel = new MyModel();
    myModel.add(new Item("A", "Item A"));
    myModel.add(new Item("B", "Item B"));
  }
  ...
}
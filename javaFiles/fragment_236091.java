public class MyApplication
{
  public static void main(String[] args)
  {
    DrawForm dform = new DrawForm();
    dform.setVisible(true);
    int sizes = dform.getSizes();

    AttributeForm aform = new AttributeForm();
    aform.setSizes(sizes);
    aform.doSomething();
  }
}
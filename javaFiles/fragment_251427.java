public class Child extends Parent
    {
          private void show()
          {
              throw new Error("Unresolved compilation problem: Cannot reduce the visibility of the inherited method from Parent");
          }

          public static void main(String[] args)
          {
                Parent p = new Child();
                p.show();
          }
    }
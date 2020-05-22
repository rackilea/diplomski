public class MyClass {

  private String anAttributeOfMyClass;

  private /*static*/ class MyInnerClass {

    public void foo() {
      /*
       * Here, I can access the attribute of the parent class
       * because I implicitly have a reference to it.
       * Try to make the nested class static an see the difference.
       */
      anAttributeOfMyClass.trim();
    }
  }

}
public class VeryComplexClass extends ComplexClass implements ComplexInterface {
  /* ... */
  @Override
  private boolean doSomethingWithUser(User u) {
    if (u == null) {
         return false;    
    }
    /* ... */
  }
}
public class B<T> {
  private A<?,?> myA;

  void someMethod() {
    for (T t : myList) {
      if (myA.getEntityId(t)!=null) {
      }
    }
  }
}
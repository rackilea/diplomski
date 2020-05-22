public abstract class B  {

 protected static A a = new A(); // Protected to make it visible to child class
 public void init() {

  a.setHost("foo"); 
 }
}
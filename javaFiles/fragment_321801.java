class MethodLevel {

  //shared among threads
SharedResource x, y ;

public void synchronized method1() {
   //multiple threads can't access
}
public void synchronized method2() {
  //multiple threads can't access
}

 public void method3() {
  //not synchronized
  //multiple threads can access
 }
}
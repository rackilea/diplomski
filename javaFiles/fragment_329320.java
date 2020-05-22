class Outer { 
  public Outer() { // constructor "method" body BEGIN
    Inner i = new Inner();        
    class Inner {
    } 
  } // constructor "method" body END
}
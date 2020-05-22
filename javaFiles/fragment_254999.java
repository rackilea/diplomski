public interface MyInterface {
  m1();
  m2();
  m3();
  m4();
  flow();
}

public abstract class Strategy implements MyInterface {      
  public final void flow() {
     //implement the flow only
     m1();
     m2();
     m3();
     m4();
  }
}
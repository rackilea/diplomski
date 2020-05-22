public class ClassA{ 
  private final int size;       
  private final ClassB b;

  public ClassA(int N){
    size = N;    
    b = new ClassB(size);
  }

  public void doSomething(){
    b.doSomething();        
  }      
}
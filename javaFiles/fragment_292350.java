public interface TheFGFunctions {
  void f();
  void g();
}

public class Tata implements TheFGFunctions { 
  @Override
  public void f(){
    //something
  }
  @Override
  public void g(){
    //something
  }
}

public class Titi implements TheFGFunctions { 
  @Override
  public void f(){
    //something
  }
  @Override
  public void g(){
    //something
  }
}

public class Toto{

  private TheFGFunctions c;

  public Toto(TheFGFunctions c){
    this.c = c;
  }
  public void notStaticFunction() {
    c.f();
    c.g();
  }
}
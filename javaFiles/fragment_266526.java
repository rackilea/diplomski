class A
{
   public A () {}
   public A (int x) { 
        doSomething(x); 
   }
   protected doSomething(int x){// do something}
}

class B extends A
{
  public B (int y)
  {
    if(y > 0){
     doSomething(y);
    }
  }
}
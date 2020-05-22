class Super{
public int i;
}
class Sub extends Super {
   public void method() {
    System.out.println(super.i); // you can access i as it is overriden by sub
   } 
}
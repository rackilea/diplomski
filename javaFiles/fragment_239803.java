package certification;
   public class Parent{
        protected int x=9;//protected access
    }


package other;
import certification.Parent;
    class Child extends Parent{
    public void testIt(){
    System.out.println("x is" + x);
        }
    public static void main(String args[]){
        Child n = new Child();
        n.testIt();
      }
}
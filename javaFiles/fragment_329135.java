public class Test {
   static MySet i1, i2, i3, i4;

   public static void main(String[] args) {
      i1 = new MySet();
      i2 = new MySet(1,2,5);
      i3 = new MySet();
      i4 = new MySet(i2);
   }
}
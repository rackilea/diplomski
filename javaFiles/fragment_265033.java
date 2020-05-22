public class Test {
 public static void main (String [] args ){
  Test test = new Test();
  int a = test.calcArea(7, 12);
  System.out.println(a);
 }

 int calcArea(int height, int width) {
  return height * width;
 }
}
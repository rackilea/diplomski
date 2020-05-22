public class Main extends JIntenalFrame
{
 public class A extends JIntenalFrame
  {
   //its an inner class
  }
 public class B extends JIntenalFrame
  {
   /*now while disposing the class B extended by the JIntenalFrame
then use the class name and the operation()
*/
 B.this.dispose();//here the actual working code
  }
}
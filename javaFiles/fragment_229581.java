class A{
  Object x(){
   System.out.print("1");
   }
  }

class B extends A{
 @Override
 String x(){
   System.out.print("2");
 }
}
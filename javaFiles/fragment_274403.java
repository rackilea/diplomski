public class MyDerivedCal extends MyCal{  
(...)
abstract MyCal newInstance(){
   return new MyDerivedCal();
   }
(...)
}
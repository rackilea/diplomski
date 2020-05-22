public class A{
     String nameA="Test";
     public A() {
         Data.setData(nameA);
     }
 }

 public class B{
      String nameB; 
      B() {
         nameB = Data.getData(); 
         System.out.println(nameB); 

      }
 }

 public class Data{

    public static String nameD;

    public static void setData(String name){ nameD = name; }

    public static String getData(){ return nameD; }
  }
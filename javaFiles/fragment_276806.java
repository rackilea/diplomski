public class Main{
  public static void main(String args[]){
     try{
       AnotherClass.main(null); // null inserted for string[] args in the AnotherClass.main
     catch(Exception ex){
       //do whatever you want
     }
  }
}
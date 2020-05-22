public class App {

     public void stuff() {
         //this refers to the current instance of App
         final Object obj = new Object();
         with(obj) {
         //this refers to obj
         }
     }
}
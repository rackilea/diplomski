public class SecondClass {
     private Test firstClass;
     private ArrayList<String> test = new ArrayList<String>();

     SecondClass() {
         firstClass = new Test();
         test = firstClass.passTestArray(); 
     }

}
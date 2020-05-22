C:\Users\oreyes\java>type SomeClass.java LoadedClass.java Main.java
//SomeClass.java
public class SomeClass{
     public SomeClass () /* added () */ {
          //load a class here
          LoadedClass lc = new LoadedClass( this );
     }
     public  void funcToCall() {
         System.out.println("SomeClass.functToCall: Being invoked :)");
     }
}
//LoadedClass.java
//In a separate file, dynamically loaded.
public class LoadedClass {
     public LoadedClass( SomeClass sc )/*added () */ {
          //Call a function in the class that loads this
          //SomeClass.funcToCall();
          sc.funcToCall();
     }
}
//Main.java
//
public class Main {
    public static void main( String ... args ) {
        new SomeClass();
    }
}
C:\Users\oreyes\java>javac SomeClass.java LoadedClass.java Main.java
C:\Users\oreyes\java>java Main
SomeClass.functToCall: Being invoked :)
C:\Users\oreyes\java>
import java.io.File;

public class sayHello {

public static native void sayHi(String message, int times);

public sayHello()
{
    System.out.println("object created :) ");

}

public void doIt(String test)
{


     File myfile = new File(test);

       if(myfile.exists())
           System.load(myfile.getAbsolutePath());
       else
           System.out.println("Something went wrong :( ");


       sayHi("C++ Funktion Call out of Java",5);
}

}
package myapp;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class ExampleClass {
public static int usefulValue;

public ExampleClass(){
    ExampleClass.usefulValue = slowMethod();
}

private int slowMethod(){ //just an example of something that takes time
    int usefulValue;
    try {
        TimeUnit.SECONDS.sleep(500);
    } catch (InterruptedException e){
        ;
    }
    usefulValue = 15;
    return usefulValue;

}
public int getUsefulValue(){
    return ExampleClass.usefulValue;
}
}
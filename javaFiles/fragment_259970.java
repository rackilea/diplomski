public static void tentimes(Runnable r){
    for(int i = 0; i < 10; i++)
       r.run();
}
...
public class PrintHello implements Runnable{
    public void run{
       System.out.println("hello")
    }
}
---
public static void main{
    ...
    tentimes(new PrintHello());
    ...
 }
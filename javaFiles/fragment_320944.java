public class Printer implements Runnable{

 String name;
 public Printer(String name){
 this.name=name;
 }
 public void run(){

  while(true){
   System.out.println("i am thread"+name);
  //in your case read or write bytes to dataline here;
  }
}
public static void main(String[] args){
 Printer print1= new Printer("a");
 Printer print2 = new Printer("b");
 new Thread(print1).start();
 new Thread(print2).start();
 }
}
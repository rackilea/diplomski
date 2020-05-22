class HelloWorld
{
   private String hello = "Hello world!";

   private void printHello(){
   System.out.println (this.hello);
}

public static void main (String args[]){
  HelloWorld hello = new HelloWorld();
  hello.printHello();
}
class Bird{
 public void fly(){
   System.out.println("I am flying");
}}

class Duck extends Bird{
 public void fly(){
   System.out.println("I can not fly");
}}

class Test{
 public static void main(String[] args){
  Bird[] birds = {new Bird(), new Duck()};
  for (Bird b: birds){
   b.fly();
  }
}
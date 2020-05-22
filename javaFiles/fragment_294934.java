public class factorial{
  public static void main(String[] args){
    System.out.println("Output:" + (factorial(3))); System.out.println("Answer:6");
    System.out.println("Output:" + (factorial(4))); System.out.println("Answer:24");
    System.out.print("--------------------");
  }     

  public static int factorial(int n){
    System.out.println("--------------------\nN:" + n);
    return factorial2(n);
  }

  public static int factorial2(int n){
    if(n == 1){
    return 1;
    }
    else{
      return n*factorial2(n-1);
    }
  }
}
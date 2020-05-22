public class Main{

  public static void main(String[] args){

     int[] values = {2, 2};

     input(values);
     System.out.println(values[0] + ", " + values[1]); // prints 1, 3
  }

  private static void input(int[] values){
      values[0] = 1;
      values[1] = 3;
  }
}
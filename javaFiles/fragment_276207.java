public class IntsToArray {
  public static int[] fill(int a, int b, int c){
      int[] array = new int[3];
      array[0] = a;
      array[1] = b;
      array[2] = c;
      return (array);
  }
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int[] array = fill(a, b, c);

        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
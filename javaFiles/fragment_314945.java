public class App {

   public static void main( String[] args ) throws IOException{

    System.out.println("1=Starter");
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number");
    int a = input.nextInt();
    if(a == 1) {
        System.out.println("Starter");
        Starter OS1 = new Starter();
        System.out.println(Arrays.toString(OS1.getterMethod()));
      }



    }

 }
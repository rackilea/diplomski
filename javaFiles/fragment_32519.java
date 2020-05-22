Scanner keyboard = new Scanner(System.in);
public  static int counter = 1;
   public void readInput()
   {
       System.out.println("for the "+counter +"line ");
       String degerler = keyboard.nextLine();
       counter++;
   }
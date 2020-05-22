public static void main(String[] args)
   {
   int a = Number();
   int total = a;      
   int b = Number();
   total = b + total;      
   int c = Number();
   total = c + total;
   int d =  Number();
   total = d + total;
   if(total <= 9)
      {
      Hearts();
      }
   if(total > 9 && total <= 18)
      {
      Clubs();
      }
   if(total > 18 && total <= 27)
      {
      Spades();
      }
   if(total > 27 && total <= 36)
      {
      Diamonds();
      }
   }


  public static int Number()
  {
      Scanner scanner = new Scanner(System.in);
      System.out.println("please enter a one digit number");
      return scanner.nextInt();
  }
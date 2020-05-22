public static void main(String [] args)
   {
       Exercise1 ex= new Exercise1();
       ex.GetNumbers();
   }

   private  void GetNumbers()
   {
       System.out.print("Type in the first number: ");
       FirstNumber = scanner.nextInt();

       System.out.print("Type in the second number: ");
       SecondNumber = scanner.nextInt();

       Answer = FirstNumber + SecondNumber;

       System.out.print("The answer is: " + Answer);
   }
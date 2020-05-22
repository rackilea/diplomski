int num;
   Scanner scan = new Scanner(System.in);

   while (true)
   {
      System.out.println("Please input a positive number: ");
      num = scan.nextInt();

      if (num < 0)
      {
        System.out.println("That number is negative.");
      }
      else if ((num >= 90 && num <= 110) || (num >= 190 && num <= 210))
      {
        break;
      }
   }
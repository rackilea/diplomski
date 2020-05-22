int n = 1;  
    int c;
    String playAgain;

     do {

          System.out.println("Enter a number");
          Scanner scanner = new Scanner(System.in);
          n = scanner.nextInt();

  if ( n < 0 )
     System.out.println("Number cant be a negative.");
  else
  {
     int x=n*(n-1)*(n-2);

     System.out.println("Factorial= "+x);

    System.out.println("Do you want to continue? (y/n):");
     playAgain = scanner.nextLine();
   } // end else
 } // end do
 while (playAgain.equals("y"));

}// end main
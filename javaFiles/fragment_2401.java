while ( inputNumber != SENTINEL )
   {
       total += number;
       System.out.print("Enter the next number or '-1' to finish. ");
       inputNumber = scan.nextInt();  <<< not number should be inputNumber
   }
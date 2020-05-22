futureValue = balance;
double doubleBalance = balance*2;

  while(futureValue <= doubleBalance)
     {
           futureValue += futureValue * (( 1 + r)/100);
           years++;
     }

  System.out.println("Your balance will double in " 
                        + years + " year(s).");
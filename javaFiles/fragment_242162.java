int temp = 0;    
do
     { 
      num = console.nextInt();
      temp = reverseDigit(temp, num);
     }
     while (num > 0);

      System.out.print(" " + temp + " ");
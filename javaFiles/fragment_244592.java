System.out.println("Now enter " + n + " integers: ");
while(n >= 0) {
    int num = input.nextInt();
    if(num > 0) {
       if (num % 2 == 0)
         even++;
       else  
         odd++;
   }
   n--;
  }

  System.out.println("You entered " + odd + " odd numbers and " + even + " even numbers.");
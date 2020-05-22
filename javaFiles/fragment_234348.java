while (number != sentinel)
 {
     count++;
     System.out.println("Enter another number");
     number = scan.nextInt();
     if (number > maxval && number != sentinel) //So you don't overwrite it when you get the sentinel character
        maxval = number;
 }
 System.out.println ("The max value is " + maxval);
int fact = 1; 
    int index = 0; 
    while (index < 10) 

    { 

        if(index == 0)
          System.out.println("\nFactorial of 0 is 1");
        else {
           fact*=index; 
           System.out.println("Factorial of " + index + " is " + fact); 
       }
       index++; 
    }
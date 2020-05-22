for (int i = 2; i <= input; i++) {
        //if its even
        if(i%2==0)
           output = output + 1.0 / factorial(i);
        else
           output = output - 1.0 / factorial(i);
 }
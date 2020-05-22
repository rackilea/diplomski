do{
        System.out.println("Enter number to calculate the average, or 0 to exit");
        number=fromKeyboard.nextInt();
        if (number == 0 && counter == 0){
            System.out.println("Must not start by zero");
            number = 1;
            continue;
        }
       ...
      }  while (number!=0);
System.out.println("\nHow many sticks do you want?");
    while(sticks >= 0){
        try{
            sticks=startInput.nextInt();
        }catch(InputMismatchException e){
            sticks=0;     //Any value which is not 0 will not break your loop. This will be re-populated when the user will supply the number again.
            System.out.println("Please enter a valid number.");
        }
    }
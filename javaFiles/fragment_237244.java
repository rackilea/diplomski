System.out.println("\nHow many sticks do you want?");
    while(sticks==0){
        try{
            sticks=startInput.nextInt();
        }catch(InputMismatchException e){
            sticks=0;     //The 0 will break your while loop, exiting your application gracefully.
            System.out.println("Please enter a valid number.");
        }
    }
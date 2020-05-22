do {
    try {
        System.out.println("Enter a your first number"); // should say "Enter a your second number"         
        i2=scan.nextDouble(); // correct
        w1++; // should be w2 - but I'd use a bool instead
    } catch(Exception e) {
        System.out.println("you must enter a number");
        //need to set w2 in here - added below
        w2 = 0;
    }
} while(w2==0);
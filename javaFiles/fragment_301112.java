while (true) {
    try {
        System.out.print ("Enter the number of Premium Seats Sold:  ");
        premiumSeats = stdin.nextInt();
        if (premiumSeats >= 0){
            break;
        } else {
            System.out.print ("Please Enter a positive integer.\n");
        }
    }
    catch (Exception e){
        System.out.print ("Please Enter a number.\n");
    }
}
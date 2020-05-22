//variables
    int sbanka = 400;
    int speed = 60;
    int speedlimit = 60;
    int ticket1 = 100;
    boolean reduc = false; // <= Fix your logic here by yourself

    //logic
    //Ticket 1
    if(speed > speedlimit + 10) {
        System.out.println("You will recieve the level 1 ticket");
        reduc = true;
    }
        else {
            System.out.println("Your speed was fine.");
        }
            //bank account calculation for ticket 1
            if(reduc == true && sbanka >-100) {
                sbanka -= 100;
                System.out.println("we will deduct 100 dollars from your checking account");
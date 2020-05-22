int attempt = 0;
    while (hours < 0 || hours > 280) {
        System.out.println("That's not possible, try again!");
        hours = reader.nextInt();
        attempt++;

        // do something if you reach the limit. The >= comparison is 
        // useless before attempt will never go over 4.
        if(attempt == 3){
            // notify the user that something wrong happened
            System.out.println("Your error message here");

            // exit the main function, further code is not processed
            return;
        }
    }
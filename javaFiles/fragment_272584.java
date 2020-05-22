int availableSeats = 0;
    for(i=0;i<6;i++) {
        for(j=0;j<8;j++) {
            if(seats[i][j] == sometargetprice){
                availableSeats++;
            }
        }
    }
    System.out.println("Total of " + availableSeats + " are available.");
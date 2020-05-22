do {

    int sum = 0, myVotes=0;

    System.out.println("Enter your votes and at the end a negative number");

    boolean average = true;

    while(average ) {

        int votes = keyboard.nextInt();
        if (votes >0) {
            sum = sum + votes;
            myVotes++;
        } else  if (votes<0){
            average = false;
        } 
    }

    if (myVotes != 0){//To handle divide by 0 exception
            System.out.println("The average is :" + (sum/myVotes));
    }
    System.out.println("Do you want to calculate another average : yes or no");

    answer = keyboard.next();

}while(answer.equalsIgnoreCase("yes"));
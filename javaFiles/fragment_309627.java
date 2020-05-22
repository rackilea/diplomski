int computerWins = 0;
int userWins = 0;
Die userDie = new Die();
Die computerDie = new Die();
for (int i=0;i<COUNT;i++) {

    System.out.println("user: "+userDie.getValue());  
    System.out.println("computer: "+computerDie.getValue());
    if(userDie.wonRoll(computerDie.getValue()) {
        userWins++;
    } else {
        computerWins++;
    }

}
System.out.println("Computer won " + computerWins + " many times");
System.out.println("User won " + userWins + " many times");
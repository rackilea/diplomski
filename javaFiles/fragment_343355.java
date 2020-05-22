System.out.println("Please enter your three numbers, one digit at a time): ");
  for(int i=0; i<3; i++){
    int userInput = input.next();
    if(userInput == generatedNumbers[i]){
        System.out.println("Your digit "+i+" is correct");
    }else{
        System.out.println("Your digit "+i+" is incorrect");
    }
  }
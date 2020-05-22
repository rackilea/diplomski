if (guess > randomNumber && guess <= 100){
    System.out.println("Your guess, "+guess+", is greater than the magic number.");
    // If the value of i at this point is 1
    i--; //Decrement i by 1
    // Now the value of i is 0. The value of i in the next iteration will be 1
}
else if (guess < randomNumber && guess > 0){
    System.out.println("Your guess, "+guess+", is less than the magic number.");
    // If the value of i at this point is 1
    i--; //Decrement i by 1
    // Now the value of i is 0. The value of i in the next iteration will be 1
}
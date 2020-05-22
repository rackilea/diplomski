private void handleButtonClick() {
    // Here we get a random integer between 0 and 99 (including 0 and 99)
    int randomNumber = new Random().nextInt(100);
    // Here we check if the random number is even
    boolean isEven = randomNumber % 2 == 0;
    // Now you can do stuff depending on the integer itself (rotation)
    // and depending on whether it's even or not.
    if(randomNumber < 50){
      // do this
    } else {
      // do that
    }

    if(isEven){
      // do this
    } else {
      // do that
    }

}
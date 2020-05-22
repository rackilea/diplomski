while (true) {
    float value;
    try {
    // code to get proper value from user & store in `value`     
    return value;
    } catch (InputMismatchException exception) {
        System.out.println("Please enter number only!");
    }
  }
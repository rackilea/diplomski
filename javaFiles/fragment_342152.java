float getFloatValue(String questionDescription){

while (true) {
    float value;
    try {
      Scanner input = new Scanner(System.in); 
      System.out.println(questionDescription+": ");
      value = input.nextFloat();
      return value;
    } catch (InputMismatchException exception) {
        System.out.println("Please enter number only!");
    }
  }
 return Float.NaN;
}
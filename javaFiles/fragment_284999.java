catch(Exception wrongType){
    System.err.println(wrongType);
    System.out.println("Please enter a number.  Start again!!");
    i=0;
    input.nextLine();  // So that it consumes the newline left over
}
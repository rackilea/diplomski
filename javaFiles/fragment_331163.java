String getStringInput(){
    System.out.println("Enter input");
    String input = scan.next();

    //check the input to make sure it is correct
    if(input.equals("foo")){
        //if the input is incorrect tell the user and get the new input
        System.out.println("Invalid Input");
        //simply return this method if the input is incorrect.
        return getStringInput();
    }

    //return the input if it is correct
    return input;
}
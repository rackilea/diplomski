//called when value changes
private void onValueChange(String data){

    //Print out data
    System.out.println(data);

    //If the data is equal to "exit", close the program
    if("exit".equals(data)){

        //Print goodbye message
        System.out.println("Received exit command! Goodbye :D");

        //Exit
        System.exit(0);
    }
}
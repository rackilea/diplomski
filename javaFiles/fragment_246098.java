boolean customerHasFinished = false;
while(!customerHasFinished){
    ...
    //Do your stuff
    ...

    System.out.print("Have you finished ? ");
    String hasFinished = input.nextLine();
    customerHasFinished = hasFinished.equals("yes");
}